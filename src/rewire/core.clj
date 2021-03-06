(ns rewire.core
  (:gen-class)
	(:import (java.io BufferedReader FileReader)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(def books ["Gen" "Exod" "Lev" "Num" "Deut" "Josh" "Judg" "Ruth" "1Sam" "2Sam"
						"1Kgs" "2Kgs" "1Chr" "2Chr" "Ezra" "Neh" "Esth" "Job" "Ps" "Prov"
						"Eccl" "Song" "Isa" "Jer" "Lam" "Ezek" "Dan" "Hos" "Joel" "Amos"
						"Obad" "Jonah" "Mic" "Nah" "Hab" "Zeph" "Hag" "Zech" "Mal" "Matt"
						"Mark" "Luke" "John" "Acts" "Rom" "1Cor" "2Cor" "Gal" "Eph" "Phil"
						"Col" "1Thess" "2Thess" "1Tim" "2Tim" "Titus" "Phlm" "Heb" "Jas"
						"1Pet" "2Pet" "1John" "2John" "3John" "Jude" "Rev" "Tob" "Jdt"
						"GkEsth" "Wis" "Sir" "Bar" "PrAzar" "Sus" "Bel" "SgThree" "EpJer"
						"1Macc" "2Macc" "3Macc" "4Macc" "1Esd" "2Esd" "PrMan"])

(defrecord Book "Gen" 1 [31, 25, 24, 26, 32, 22, 24, 22, 29,
			32, 32, 20, 18, 24, 21, 16, 27, 33,
			38, 18, 34, 24, 20, 67, 34, 35, 46,
			22, 35, 43, 55, 32, 20, 31, 29, 43,
			36, 30, 23, 23, 57, 38, 34, 34, 28,
                         34, 31, 22, 33, 26])

;;(defn process-file [file-name]
;;  (with-open [rdr (BufferedReader. (FileReader. file-name))]
;;    (doseq [line (line-seq rdr)] (println line))))

(defn bible? [token]
	false)

(defn space? [^Character c]
	(Character/isWhitespace c))

(defn digit? [^Character c]
  (= (Character/getType c)
     (Character/DECIMAL_DIGIT_NUMBER)))

(defn separator? [^Character c]
  (= (Character/getType c)
     (Character/DECIMAL_DIGIT_NUMBER)))

(defn process-file [file-name line-func line-acc]
  (with-open [rdr (BufferedReader. (FileReader. file-name))]
    (reduce line-func line-acc (line-seq rdr))))

(defn process-line [acc	line]
  (reduce #(assoc %1 %2	(+ (get	%1 %2 0) 1))	acc (.split line " ")))

(prn (process-file "test/rewire/data.txt" process-line 0))

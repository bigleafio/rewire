(ns rewire.tokenize)

(defn space? [c]
	(Character/isWhitespace c))

(defn is_continue? [c]
	(= "-" c))

(is_continue? '-')

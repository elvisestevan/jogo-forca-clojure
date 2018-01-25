(ns jogo-forca.core
  (:gen-class))

(def total-de-vidas 6)

(defn perdeu [] (print "Você perdeu!"))
(defn ganhou [] (print "Você ganhou!"))

(defn letras-faltantes [palavra acertos]
  (remove (fn [letra] (contains? acertos (str letra))) palavra)
)

(defn acertou-a-palavra-toda? [palavra acertos] 
  (empty? (letras-faltantes palavra acertos))
)

(defn le-letra! [] (read-line))

(defn acertou? [chute palavra]
  (.contains palavra chute)
)

(defn imprime-forca [vidas palavra acertos]
  (println "Vidas " vidas)
  (doseq [letra (seq palavra)] 
    (if (contains? acertos (str letra))
      (print letra " ") (print "_" " ")
    ))
  (println)
)

(defn jogo [vidas palavra acertos]
  (imprime-forca vidas palavra acertos)
  (cond 
    (= vidas 0) (perdeu)
    (acertou-a-palavra-toda? palavra acertos) (ganhou)
  :else
    (let [chute (le-letra!)]
      (if (acertou? chute palavra)
        (do
          (println "Acertou!")
          (recur vidas palavra (conj acertos chute))
        )
        (do
          (println "Eroooow!")
          (recur (dec vidas) palavra acertos)
        )
      )
    )
  )
)

(defn fib [n]
  (if (= n 0)
    0
    (if (= n 1)
      1
      (+ (fib (- n 1)) (fib (- n 2)))
    )
  )
)

(defn fibrecur[n]
  (loop [a 1 b 1 numero 2]
    (if 
      (= numero n) b
      (recur b (+ a b) (inc numero))
    )    
  )
)

(defn soma[n]
  (loop [contador 1 soma 0]
    (if 
      (> contador n) soma
      (recur (inc contador) (+ contador soma))
    )
  )
)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

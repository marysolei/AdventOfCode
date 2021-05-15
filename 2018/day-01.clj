(ns testing-project.advent-2018-day1
  (:require [clojure.test :refer :all])
  (:require [clojure.string :as str])
  (:import (java.util HashSet))
  )


;;summation of a vector of numbers
(def input [ -1, -2, -3])
(apply + input)

;;;;;;;;;; part 1 ;;;;;;;;;;
(def data "-5\n-2\n+1\n+14\n+7\n+5\n-14\n-4\n-5\n-12\n+7\n-5\n+17\n+5\n-13\n-12\n+15\n+22\n-5\n-6\n-12\n+20\n+4\n+2\n+17\n-1\n+18\n-7\n-1\n-17\n+11\n-12\n-5\n-2\n+9\n+2\n-6\n-17\n-1\n+2\n-3\n+15\n+19\n+9\n-8\n+13\n+1\n+11\n+16\n+3\n-16\n-7\n-15\n-15\n+12\n+16\n+18\n+1\n-9\n+16\n-9\n-19\n+17\n+1\n-15\n+13\n-9\n-8\n-1\n+7\n+17\n+13\n+15\n-17\n-3\n+12\n-10\n+5\n+4\n-16\n+15\n+3\n+19\n+1\n-2\n+19\n-16\n-11\n+4\n-10\n-8\n+13\n+13\n+19\n-6\n-19\n+1\n-4\n+18\n+15\n+16\n-18\n+12\n+3\n-9\n+8\n+3\n-9\n+11\n+4\n+8\n+1\n+6\n-10\n-3\n+15\n+16\n+15\n+12\n-14\n+4\n-14\n-7\n-3\n+14\n+4\n+3\n-6\n-7\n+11\n-2\n-18\n+17\n-3\n+14\n+18\n+6\n+8\n+18\n-13\n-7\n+17\n-18\n-10\n-15\n+13\n-16\n+5\n-10\n+15\n-8\n-4\n+14\n+13\n-10\n-14\n+7\n+5\n+13\n-4\n+12\n+3\n+14\n-7\n+6\n+12\n+17\n-18\n+3\n-6\n-3\n-14\n-1\n+13\n+19\n+3\n+9\n+4\n+11\n+12\n+3\n+1\n+14\n+7\n-17\n+12\n+11\n+6\n-7\n+4\n-11\n-1\n+6\n-19\n-10\n-16\n-2\n-19\n+7\n+9\n-3\n+5\n+12\n+15\n+8\n+11\n+1\n+8\n+15\n-9\n-9\n-8\n-10\n-3\n-16\n+7\n-17\n+9\n-5\n+16\n-15\n-4\n+15\n-5\n-25\n-6\n+1\n+4\n+17\n+19\n-13\n+17\n+7\n+19\n+2\n+4\n+10\n+16\n-9\n+19\n+13\n+3\n-10\n+9\n+5\n+1\n+18\n-11\n-14\n-4\n-5\n-13\n-7\n-12\n+2\n+3\n+6\n-16\n-1\n+13\n-10\n-4\n-1\n-3\n+9\n+22\n+4\n-18\n+17\n+11\n-21\n-17\n-18\n-8\n+12\n+6\n+15\n+12\n+10\n-7\n+18\n+10\n-8\n-10\n-18\n+11\n-17\n+25\n+15\n-9\n-19\n+38\n-3\n-6\n-23\n+34\n-25\n-5\n-12\n+25\n+14\n+17\n+30\n+3\n+9\n-8\n+16\n+21\n+21\n+4\n-12\n+23\n-13\n+9\n+3\n+6\n+13\n+15\n+6\n-7\n+15\n+12\n-10\n+13\n+12\n-7\n+13\n+4\n-9\n+18\n-10\n+5\n+8\n-7\n+2\n-14\n-12\n-1\n-6\n-16\n-18\n-3\n+1\n+12\n-6\n+15\n-17\n+15\n+13\n+6\n-15\n+26\n+1\n-21\n-3\n-21\n-4\n+14\n-1\n-19\n-11\n+13\n-10\n-14\n+2\n-17\n-23\n+25\n-16\n+8\n-30\n+17\n-44\n+13\n-19\n+5\n-9\n-12\n+10\n+14\n+17\n+24\n-15\n+7\n-61\n-103\n-18\n+21\n-22\n-6\n-9\n-6\n-9\n-7\n-15\n-17\n+4\n-1\n+10\n+8\n+14\n-4\n+15\n-16\n-6\n-16\n-15\n-12\n+15\n+10\n-15\n+3\n+15\n-10\n-17\n+3\n-5\n-12\n+4\n+3\n-37\n-7\n+14\n-18\n-8\n+6\n-11\n+14\n+30\n+7\n+23\n+39\n-12\n+11\n-8\n+11\n-1\n+56\n-28\n-12\n+7\n+34\n+47\n+21\n+88\n+61\n+18\n+10\n-99\n-287\n+26\n-858\n-209\n-61255\n+2\n-7\n-8\n+12\n+18\n+17\n-14\n-2\n+14\n+4\n+3\n+3\n-15\n+21\n+3\n+20\n+1\n+3\n-1\n-25\n-2\n+7\n-9\n+17\n-19\n-6\n-13\n+2\n-4\n-3\n-14\n-8\n+12\n-20\n+17\n-40\n+11\n+3\n-20\n-16\n-18\n-3\n-6\n-10\n+4\n+20\n-12\n-3\n+11\n+16\n-2\n+4\n-9\n+28\n-12\n+5\n+17\n-13\n+35\n+25\n+2\n+35\n-17\n-8\n+31\n+3\n-39\n-46\n+3\n-96\n-18\n-14\n-14\n-12\n+9\n+15\n+3\n+18\n-8\n+1\n-2\n-15\n+13\n+14\n-13\n-3\n+7\n-11\n-15\n-17\n-12\n-15\n-17\n+9\n+7\n-10\n-8\n-3\n+9\n+16\n+3\n+15\n-14\n-5\n-9\n+1\n-3\n+10\n+3\n-18\n-21\n-11\n+2\n-17\n-17\n-7\n-11\n+8\n+11\n-2\n-7\n-1\n-19\n-2\n-16\n+1\n+5\n+11\n+18\n+5\n+17\n+2\n-5\n-2\n+19\n-4\n+12\n+2\n+20\n-13\n-20\n-12\n+10\n+4\n+14\n-1\n+12\n+13\n-10\n-13\n-8\n-1\n+14\n+16\n+6\n+10\n+18\n+19\n+14\n-1\n+6\n-13\n-9\n+10\n-20\n+1\n+1\n-12\n+6\n+7\n-15\n-13\n-2\n+14\n-19\n-5\n-10\n-17\n+15\n-5\n+8\n+20\n+9\n+14\n-6\n+4\n-3\n+19\n+18\n-14\n-3\n-8\n+4\n+16\n+7\n-3\n-5\n+19\n-2\n+12\n+19\n+12\n-10\n-17\n-40\n+1\n-11\n+19\n-27\n-9\n+45\n-27\n+31\n+1\n-25\n+41\n+58\n-5\n-39\n-112\n+1\n-8\n-3\n-6\n-15\n-3\n-9\n+13\n+13\n-24\n+3\n-4\n+13\n-19\n-21\n+16\n-20\n-10\n-15\n-16\n-1\n-13\n-12\n-17\n+16\n+17\n+16\n-2\n-9\n-1\n-19\n+8\n+5\n-18\n+17\n-19\n-19\n-12\n+14\n-18\n-12\n+10\n+9\n-13\n-8\n+19\n+16\n+13\n-5\n+2\n+16\n-15\n+17\n+9\n+10\n+2\n-5\n+20\n+16\n-8\n-4\n+16\n+6\n-7\n-2\n-11\n+18\n+11\n-1\n+2\n+5\n+3\n+40\n-38\n+22\n-11\n-15\n-27\n+7\n-25\n+4\n-11\n-15\n-12\n+15\n-20\n-13\n+9\n-13\n+7\n-5\n+10\n+18\n+24\n+8\n+15\n-6\n-10\n-10\n-1\n-4\n-3\n-17\n+7\n-15\n+20\n-19\n-18\n-14\n-4\n-26\n-22\n-5\n+17\n+6\n+13\n+9\n+7\n+28\n-11\n-8\n+57\n-23\n-37\n-11\n-43\n+3\n-14\n+3\n-14\n+13\n-15\n+6\n-23\n+8\n+12\n-8\n+15\n+16\n+2\n-9\n-14\n+18\n+19\n-1\n-43\n-2\n-3\n-13\n+5\n-6\n-13\n-20\n+15\n+13\n-12\n+3\n+2\n+3\n+11\n+7\n-17\n-8\n-13\n+18\n-17\n-2\n-13\n+5\n+3\n+1\n-11\n+20\n+4\n+2\n-1\n-19\n-8\n-19\n+1\n-6\n-12\n+8\n-6\n-5\n+1\n+6\n+9\n-12\n+13\n+10\n-14\n+20\n-11\n+9\n+9\n-3\n-18\n+9\n-5\n+9\n+2\n-9\n-19\n-4\n-10\n+7\n-8\n+68\n+30\n+2\n-9\n+12\n-65\n+15\n-26\n-9\n-15\n-67\n-38\n-36\n-37\n-7\n+18\n-20\n-44\n+35\n-70\n-85\n+14\n+18\n-499\n+209\n-61690\n-5\n+15\n-4\n+3\n+5\n+6\n+15\n+16\n+3\n-4\n+12\n-14\n-7\n-9\n-15\n+2\n-1\n-11\n-21\n-8\n-2\n-15\n+19\n+7\n-10\n-19\n-3\n-14\n+4\n+9\n+13\n-16\n-14\n+2\n+10\n-19\n+6\n+16\n+11\n+7\n-14\n-9\n-21\n-7\n-12\n+2\n+12\n-6\n+125503")

;split the given string line by line
(defn splitLine [input]
    (str/split-lines input)
  )
;convert the given vector of string to a vector of long
(defn parser [input]
    ; (def v (str/split-lines input))
    (mapv #(Long/parseLong %) (splitLine input))
  )
;summation of all the values
(defn part1-function []
    (apply + (parser data))
  )
;answer: 454

;;;; part 2 ;;;;
;; reduce
(defn reduce-func []
  ;the function takes  2 args keys (initial value we provide)
  ;& the next item in the collection we are reducing over
  (reduce (fn [{:keys [seen sum]} current]
            (let [res (+ sum current)]
              (if (contains? seen res)
                ;acts as break
                (reduced res)
                ;returns a new collection that contains that entry
                ; which will be used as arg to our function for
                ; next step in reduction
                {:seen (conj seen res)
                 :sum res})
              )
            )
          {:seen #{0} :sum 0}
          (cycle parsedData)
          )
  )
(reduce-func)
; answer: 566





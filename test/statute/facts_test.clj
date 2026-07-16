(ns statute.facts-test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [statute.facts :as facts]))

(deftest tur-has-spec-basis
  (let [sb (facts/spec-basis "TUR")]
    (is (= 2 (count sb)))
    (is (every? #(str/starts-with? (:statute/url %) "https://") sb))
    (is (every? :statute/law-number sb))))

(deftest unknown-jurisdiction-has-no-spec-basis
  (is (nil? (facts/spec-basis "ATL")))
  (is (nil? (facts/spec-basis "ZZZ"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["TUR" "JPN" "ATL"])]
    (is (= 3 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["ATL" "JPN"] (:missing-jurisdictions c)))))

(deftest by-topic-filters
  (is (= ["tur.kanun-6698-2016-kisisel-verilerin-korunmasi-kanunu"]
         (mapv :statute/id (facts/by-topic "TUR" :privacy))))
  (is (empty? (facts/by-topic "TUR" :labor)))
  (is (empty? (facts/by-topic "ATL" :privacy))))

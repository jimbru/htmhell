(ns htmhell.core-test
  (:require [clojure.test :refer :all]
            [htmhell.core :refer :all]))

(deftest escape-test
  (is (= (escape "\"><script>alert();</script>&quot;")
         "&quot;&gt;&lt;script&gt;alert();&lt;/script&gt;&amp;quot;")))

(ns htmhell.core-test
  (:require [clojure.test :refer :all]
            [htmhell.core :refer :all]))

(deftest escape-test
  (is (= (escape "\"><script>alert();</script>&quot;")
         "&quot;&gt;&lt;script&gt;alert();&lt;/script&gt;&amp;quot;")))

(deftest render-string-test
  (testing "basic functionality"
    (let [s "these{{foo}}are making me {{ bar }}"]
      (is (= (render-string s {:foo " pretzels " :bar "thirsty"})
             "these pretzels are making me thirsty"))))
  (testing "missing data"
    (let [s "{{foo}} now {{bar}}"]
      (is (= (render-string s {:foo "serenity"})
             "serenity now "))))
  (testing "special chars in name"
    (let [s "The {{Store_Name}} called, {{they're}} running out of {{some-person}}!"]
      (is (= (render-string s {:Store_Name "Jerk Store" :some-person "you"})
             "The Jerk Store called, {{they're}} running out of you!"))))
  (testing "HTML escaping"
    (let [s "get rid of the {{things}}"]
      (is (= (render-string s {:things "<b>exclamation points!</b>"})
             "get rid of the &lt;b&gt;exclamation points!&lt;/b&gt;")))))

(ns htmhell.core
  (:require [clojure.java.io :as io]
            [clojure.string :as string]))

(defn escape
  "Escape an HTML string."
  [html]
  (.. html
      (replace "&" "&amp;")
      (replace "<" "&lt;")
      (replace ">" "&gt;")
      (replace "\"" "&quot;")
      (replace "'" "&apos;")))

(defn render-string
  "Renders the string with the given data. Dynamic elements should be wrapped
  in double curly-braces, like {{this}}. The element's name must be alphanumeric
  characters only. The data should be a map containing a keyword key matching
  each dynamic element name."
  [s data]
  (string/replace s
                  #"\{\{\s*(\p{Alnum}*)\s*\}\}"
                  #(escape (get data (keyword (% 1)) ""))))

(defn read-template
  "Reads in the template from resources."
  [n]
  (slurp (io/resource n)))

(defn render-template
  "Reads in the template from resources and renders it
  with the given data (see also `render-string`)."
  [n data]
  (render-string (read-template n) data))

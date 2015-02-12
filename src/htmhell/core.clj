(ns htmhell.core)

(defn escape
  "Escape an HTML string."
  [html]
  (.. html
      (replace "&" "&amp;")
      (replace "<" "&lt;")
      (replace ">" "&gt;")
      (replace "\"" "&quot;")
      (replace "'" "&apos;")))

# htmhell

A really garbage HTML library.

Contains all sorts of functionality:

- HTML escaping that probably isn't insecure
- America's #1 worst templating system

## Usage

1. Add this as a dependency in your `project.clj`:
  ```clojure
  [htmhell "0.1.0"]
  ```

2. Write your garbage code:
  ```clojure
  (require '[htmhell.core :as html])

  (def my-html-escaped-string (html/escape "<script>alert('Jerry, hello!');</script>"))
  ```

3. Write your garbage template:
  ```html
  <!-- resources/index.html -->
  <html>
    <div>Kramer's first name is {{name}}.</div>
  </html>
  ```

4. Render your garbage data:
  ```clojure
  (def my-html (html/render-template "index.html" {:name "Cosmo"}))
  ```

## FAQs

1. Does it do `<blank>`?

  No.

2. How does it do `<blank>`?

  Regex, mostly.

3. Is there any redeeming value here?

  You be the judge!

## License

Copyright © 2015 Jim Brusstar

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.

# Yandex.Translate clojure library

A Clojure library designed to translate text from one language to another using Yandex.Translate web API.

## Statuses

[![Dependencies Status](http://jarkeeper.com/moffff/yandex-translate/status.png)](http://jarkeeper.com/moffff/yandex-translate)

## Install

Add to project.clj:

```
[yandex-translate "0.1.0"]
```

## Usage

```
user=> (use 'yandex.translate)
nil

user=> (translate "Hello" {:api-key "Yandex.Translate API key"
                           :lang "en-es"})
"Hola"

user=> (translate "Hello" {:api-key "Yandex.Translate API key"
                           :lang "es"})
"Hola"

user=> (batch-translate ["Hello" "nice rabbit"] {:api-key "Yandex.Translate API key"
                                                 :lang "en-es"})))))
["Hola" "bonito conejo"]

user=> (batch-translate ["Hello" "nice rabbit"] {:api-key "Yandex.Translate API key"
                                                 :lang "es"})))))
["Hola" "bonito conejo"]
```

## Tips

If you need to get API key for Yandex.Translate you should visit
[Yandex.Translate API Keys](https://translate.yandex.com/apikeys).

## License

Copyright © 2013 Artem Kornienko (contacts@theteam.io) and released under an [MIT license](http://opensource.org/licenses/MIT).

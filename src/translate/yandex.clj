(ns translate.yandex
  "A Clojure library designed to translate text from one language to another using Yandex.Translate web API"
  (:require [clojure.string :as string]
            [clj-http.client :as http]))

;-----------------------;
;-- Stubs --------------;
;-----------------------;
(defn empty-str [] "")
(defn empty-vector [] [""])

;-----------------------;
;-- Basic operations ---;
;-----------------------;
(defn generate-params
  "Generate params for request to Yandex.Translate API"
  [text options]

  {"key"  (:api-key options)
   "lang" (:lang options)
   "text" text})

(defn get-response
  "Make a request to Yandex.Translate API"
  [params]

  (http/post "https://translate.yandex.net/api/v1.5/tr.json/translate"
                  {:as :json
                   :headers {"X-HTTP-Method-Override" "GET"}
                   :form-params params}))

;-----------------------;
;-- Sub operations -----;
;-----------------------;
(defn get-translation
  "Get translation of text from Yandex.Translate API"
  [text options]

  (let [params (generate-params text options)
        response (get-response params)]
    (-> response :body :text first)))

(defn get-batch-translations
  "Get batch translations of texts from Yandex.Translate API"
  [texts options]

  (let [params (generate-params texts options)
        response (get-response params)]
    (-> response :body :text)))

;-----------------------;
;-- Main operations ----;
;-----------------------;
(defn translate
  "Translate text using Yandex.Translate web API"
  [text options]

  (if (string/blank? text)
    (empty-str)
    (get-translation text options)))


(defn batch-translate
  "Batch translate texts using Yandex.Translate web API"
  [texts options]

  (if (empty? texts)
    (empty-vector)
    (get-batch-translations texts options)))

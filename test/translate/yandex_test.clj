(ns translate.yandex-test
  (:use clojure.test
        translate.yandex))

(deftest empty-str-text-test
  (testing "Empty string expected if text is empty string"
    (is (= "" (translate "" {})))))

(deftest nil-text-test
  (testing "Empty string expected if text is nil"
    (is (= "" (translate nil {})))))

(deftest empty-str-batch-text-test
  (testing "Empty vector expected if text is empty string in batch translation"
    (is (= [""] (batch-translate "" {})))))

(deftest nil-batch-text-test
  (testing "Empty vector expected if text is nil in batch translation"
    (is (= [""] (batch-translate nil {})))))


; this code is commented because you need to specify your own Yandes.Translate API key
(comment
  ;(defn api-key-value [] "Yandex.Translate API key")

  (deftest hello-text-double-lang-test
    (testing "Hello should be Hola in Spanish"
      (is (= "Hola" (translate "Hello" {:api-key (api-key-value)
                                         :lang "en-es"})))))
  (deftest hello-text-single-lang-test
    (testing "Hello should be Hola in Spanish with auto-detection of the source language"
      (is (= "Hola" (translate "Hello" {:api-key (api-key-value)
                                         :lang "es"})))))
  (deftest batch-vector-text-double-lang-test
    (testing "Vector: Hello should be Hola (in Spanish) and nice rabbit should be bonito conejo (in Spanish)"
      (is (= ["Hola" "bonito conejo"] (batch-translate ["Hello" "nice rabbit"] {:api-key (api-key-value)
                                                                             :lang "en-es"})))))
  (deftest batch-vector-text-single-lang-test
    (testing "Vector: Hello should be Hola (in Spanish) and nice rabbit should be bonito conejo (in Spanish) with auto-detection of the source language"
      (is (= ["Hola" "bonito conejo"] (batch-translate ["Hello" "nice rabbit"] {:api-key (api-key-value)
                                                                             :lang "es"})))))
  (deftest batch-list-text-double-lang-test
    (testing "List: Hello should be Hola (in Spanish) and nice rabbit should be bonito conejo (in Spanish)"
      (is (= ["Hola" "bonito conejo"] (batch-translate '("Hello" "nice rabbit") {:api-key (api-key-value)
                                                                             :lang "en-es"})))))
  (deftest batch-list-text-single-lang-test
    (testing "List: Hello should be Hola (in Spanish) and nice rabbit should be bonito conejo (in Spanish) with auto-detection of the source language"
      (is (= ["Hola" "bonito conejo"] (batch-translate '("Hello" "nice rabbit") {:api-key (api-key-value)
                                                                             :lang "es"}))))))

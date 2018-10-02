(ns luminus-transit.core-test
  (:require [clojure.test :refer :all]
            [luminus-transit.time :refer :all]))

(deftest time-transit-test
  (testing "test transit roundtrip"
    (let [local-time-str "19:34:18.110"
          local-date-str "2018-10-02"
          local-date-time-str "2018-10-02T19:35:13.591"
          zoned-date-time-str "2018-10-02T19:34:56.767-0400"
          utc-date-time-str "2018-10-02T19:34:56.767Z"
          local-time (java.time.LocalTime/parse local-time-str iso-local-time)
          local-date (java.time.LocalDate/parse local-date-str iso-local-date)
          local-date-time (java.time.LocalDateTime/parse local-date-time-str iso-local-date-time)
          zoned-date-time (java.time.ZonedDateTime/parse zoned-date-time-str iso-zoned-date-time)
          utc-date-time (java.time.ZonedDateTime/parse utc-date-time-str iso-zoned-date-time)]
      (is (= local-time-str (.format local-time iso-local-time)))
      (is (= local-date-str (.format local-date iso-local-date)))
      (is (= local-date-time-str (.format local-date-time iso-local-date-time)))
      (is (= zoned-date-time-str (.format zoned-date-time iso-zoned-date-time)))
      (is (= utc-date-time-str (.format utc-date-time iso-zoned-date-time))))))

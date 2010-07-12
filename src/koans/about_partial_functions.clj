(meditations
  "Partial functions allow procrastination"
  (= 20 (let [multiply-by-5 (partial * 5)]
          (___ __)))

  "Don't forget: first things first"
  (= [__ __ __ __]
     (let [ab-adder (partial concat [:a :b])]
       (ab-adder [__ __]))))

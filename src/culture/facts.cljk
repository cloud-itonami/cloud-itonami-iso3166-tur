(ns culture.facts
  "Country-level regional-culture catalog for Turkey (TUR) -- national
  dishes, protected products, beverages, crafts, festivals and heritage
  sites, per ADR-2607171400 addendum 2 (cloud-itonami-municipality-
  culture-catalog Wave 1, in com-junkawasaki/root). Sibling namespace to
  `marketentry.facts` / `statute.facts` (ADR-2607141700); city-level
  counterparts live in the cloud-itonami-municipality-* repos.

  Catalog is keyed by UPPERCASE ISO3 (mirrors `statute.facts`); entries
  carry no :culture/municipality (that attribute is city-level only).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of culture entries."
  {"TUR"
   [{:culture/id "tur.dish.kebab"
     :culture/name "Kebab"
     :culture/country "TUR"
     :culture/kind :dish
     :culture/summary "Roasted meat dishes originating in the Middle East, with contested origin debated between Greeks and Turks; Turkey developed distinct varieties (şiş kebap, Adana kebabı) and Turkish immigrants popularized döner kebab in Germany from the 1970s."
     :culture/url "https://en.wikipedia.org/wiki/Kebab"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "tur.dish.baklava"
     :culture/name "Baklava"
     :culture/country "TUR"
     :culture/kind :dish
     :culture/summary "Layered filo-dough pastry dessert popular across West Asia, Southeast Europe, Central Asia and North Africa with contested origins (Greek, Arabic, and Central Asian Turkic theories); its Turkish version was probably developed in the imperial kitchens of Topkapı Palace, and Gaziantep's pistachio baklava received the EU's first Protected Geographical Indication."
     :culture/url "https://en.wikipedia.org/wiki/Baklava"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "tur.dish.turkish-delight"
     :culture/name "Turkish delight"
     :culture/country "TUR"
     :culture/kind :dish
     :culture/summary "Family of confections based on a gel of starch and sugar, traditionally flavored with rosewater or nuts; origins are disputed (some sources credit an Ottoman confectioner in 1777) but it remains embedded in Turkish culture, commonly served during celebrations and religious festivals."
     :culture/url "https://en.wikipedia.org/wiki/Turkish_delight"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "tur.beverage.turkish-coffee"
     :culture/name "Turkish coffee"
     :culture/country "TUR"
     :culture/kind :beverage
     :culture/summary "Traditional brewing method using very finely ground coffee beans in a special pot called a cezve, with the grounds remaining in the cup; UNESCO recognized Turkish coffee culture and tradition on the Representative List of the Intangible Cultural Heritage of Humanity."
     :culture/url "https://en.wikipedia.org/wiki/Turkish_coffee"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "tur.craft.iznik-pottery"
     :culture/name "Iznik pottery"
     :culture/country "TUR"
     :culture/kind :craft
     :culture/summary "Decorated ceramic produced from the last quarter of the 15th century until the end of the 17th century in the town of İznik, Anatolia; extensively commissioned by the Ottoman court to decorate imperial buildings."
     :culture/url "https://en.wikipedia.org/wiki/Iznik_pottery"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "tur.festival.mevlevi-sema-ceremony"
     :culture/name "Mevlevi Sema Ceremony"
     :culture/country "TUR"
     :culture/kind :festival
     :culture/summary "Whirling meditation ceremony of the Mevlevi Sufi order founded in Konya, Turkey by followers of 13th-century poet Rumi; UNESCO designated the Mevlevi Sema Ceremony a Masterpiece of the Oral and Intangible Heritage of Humanity in 2005."
     :culture/url "https://en.wikipedia.org/wiki/Mevlevi_Order"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "tur.heritage.hagia-sophia"
     :culture/name "Hagia Sophia"
     :culture/country "TUR"
     :culture/kind :heritage
     :culture/summary "Mosque and major cultural site in Istanbul originally built as a Byzantine church in 537 CE; part of the Historic Areas of Istanbul UNESCO World Heritage Site designated in 1985."
     :culture/url "https://en.wikipedia.org/wiki/Hagia_Sophia"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "tur.heritage.cappadocia"
     :culture/name "Cappadocia"
     :culture/country "TUR"
     :culture/kind :heritage
     :culture/summary "Historical region in Central Anatolia known for distinctive geological rock formations and early Christian heritage, including Göreme National Park and underground cities, recognized as a UNESCO World Heritage Site."
     :culture/url "https://en.wikipedia.org/wiki/Cappadocia"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [iso3] (get catalog iso3))

(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-tur culture catalog "
                 "(ADR-2607171400 addendum 2, Wave 1): " (count (get catalog "TUR"))
                 " TUR entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [iso3 kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis iso3)))

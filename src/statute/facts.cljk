(ns statute.facts
  "General-law compliance catalog for Turkey (TUR) -- a 39th country-level
  entry (see cloud-itonami-iso3166-jpn/-usa/-gbr/-deu/-fra/-can/-aus/-kor/
  -nld/-ita/-esp/-swe/-nor/-dnk/-fin/-prt/-bel/-bra/-mex/-chl/-arg/-zaf/-col/
  -ury/-cri/-pan/-ecu/-pry/-gtm/-hnd/-ind/-ken/-tha/-are/-vnm/-idn/-phl/-egy
  for the first thirty-eight) per ADR-2607141700
  (cloud-itonami-compliance-fact-federation).

  Reuses this tick-window's already-verified capital-status finding
  from cloud-itonami-municipality-tur-ankara (tick 113): Ankara has
  been Turkey's stable capital since 29 October 1923, with no ongoing
  transition ambiguity, unlike Egypt/Indonesia checked earlier this
  session.

  Türk Ticaret Kanunu (Turkish Commercial Code), Kanun No. 6102 --
  title/number/13 January 2011 adoption date directly confirmed by
  reading mgm.adalet.gov.tr's (Ministry of Justice, an official
  Turkish government domain) own hosted PDF text via the Read-tool
  saved-path fallback (the same PDF's mevzuat.gov.tr mirror rendered
  the number/date fields as illegible boxes via font-subsetting, so
  the adalet.gov.tr mirror was used instead once it rendered legibly).

  Kişisel Verilerin Korunması Kanunu (Personal Data Protection Law),
  Kanun No. 6698 -- title directly confirmed via the Read-tool
  fallback on mgm.adalet.gov.tr's PDF (though its number/date fields
  were themselves illegible there too); the law number and 24 March
  2016 adoption date were then directly confirmed via
  mevzuat.gov.tr's own .doc mirror, which WebFetch rendered legibly
  (avoiding the PDF font-subsetting issue entirely).

  An entry not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url/date.")

(def catalog
  "ISO3166 alpha-3 -> vector of statute entries."
  {"TUR"
   [{:statute/id "tur.kanun-6102-2011-turk-ticaret-kanunu"
     :statute/title "Türk Ticaret Kanunu (Turkish Commercial Code)"
     :statute/jurisdiction "TUR"
     :statute/kind :law
     :statute/law-number "Kanun No. 6102"
     :statute/url "https://mgm.adalet.gov.tr/Resimler/SayfaDokuman/181020191508056102sk.pdf"
     :statute/url-provenance :official-adalet-gov-tr
     :statute/enacted-date "2011-01-13"
     :statute/retrieved-at "2026-07-17"
     :statute/topic #{:corporate-governance :incorporation}}
    {:statute/id "tur.kanun-6698-2016-kisisel-verilerin-korunmasi-kanunu"
     :statute/title "Kişisel Verilerin Korunması Kanunu (Personal Data Protection Law)"
     :statute/jurisdiction "TUR"
     :statute/kind :law
     :statute/law-number "Kanun No. 6698"
     :statute/url "https://www.mevzuat.gov.tr/MevzuatMetin/1.5.6698.doc"
     :statute/url-provenance :official-mevzuat-gov-tr
     :statute/enacted-date "2016-03-24"
     :statute/retrieved-at "2026-07-17"
     :statute/topic #{:data-protection :privacy}}]})

(defn spec-basis [jurisdiction] (get catalog jurisdiction))

(defn coverage
  ([] (coverage (keys catalog)))
  ([jurisdictions]
   (let [have (filter catalog jurisdictions)
         missing (remove catalog jurisdictions)]
     {:requested (count jurisdictions)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-tur statute.facts Wave 0 (ADR-2607141700): "
                 (count (get catalog "TUR")) " Turkey entries seeded "
                 "with adalet.gov.tr/mevzuat.gov.tr citations. "
                 "Extend `statute.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [jurisdiction topic]
  (filterv #(contains? (:statute/topic %) topic) (spec-basis jurisdiction)))

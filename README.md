# 🐻 Zimní spánek medvěda Barnabáše

Textová hra napsaná v Javě.
Hraješ za medvěda Barnabáše který se připravuje na zimní spánek.  
Prozkoumej les, sbírej předměty, potkávej postavy a splň všechny podmínky,
abys mohl ulehnout ke spánku.

---

## 🎮 Popis hry

Zima se blíží a medvěd Barnabáš musí připravit svou jeskyni na hibernaci. Musí:
- **Sníst dostatek jídla**, aby přežil zimu (dosáhnout nasycení ≥ 100)
- **Vyrobit si pohodlnou postel** z deky a mechu
- **Zablokovat vchod do jeskyně** těžkým kamenem, aby byl v bezpečí a teple

Aby to všechno zvládl, musí Barnabáš prozkoumat okolní les, obchodovat se zvířaty a vypořádat se s jezevcem, který mu blokuje cestu.

---

## ️ Lokace

| Lokace            | Popis                                                                 |
|-------------------|-----------------------------------------------------------------------|
| **Jeskyně**       | Barnabášův domov. Hra zde začíná i končí.                             |
| **Rozcestí**      | Křižovatka spojující všechny hlavní oblasti.                          |
| **Doubravka**     | Hustý les, domov veverky.                                             |
| **Včelí louka**   | Zdroj medu – pozor na včelí roj!                                      |
| **Temné Houští**  | Zarostlá oblast ukrývající velký kámen.                               |
| **Opuštěný srub** | Lidské stavení s užitečnými předměty, ale cestu hlídá mrzutý jezevec. |
| **Bystřina**      | Potok plný lososů k ulovení.                                          |
| **Vyhlídka**      | Vyhlídkový bod, kde roste léčivá bylina.                              |

---

##  Předměty

| Předmět | Lokace | Použití |
|---|---|---|
| **Oříšek** | Doubravka | Vyměň s veverkou za mech |
| **Mech** | Získáno od veverky | Použij v jeskyni k výrobě postele |
| **Hrnec medu** | Včelí louka | Sněz pro zvýšení nasycení |
| **Losos** | Bystřina | Sněz pro zvýšení nasycení |
| **Velký kámen** | Temné Houští | Použij v jeskyni k zablokování vchodu |
| **Stará deka** | Opuštěný srub | Použij v jeskyni k výrobě postele |
| **Léčivá bylina** | Vyhlídka | Dej ji jezevci, aby uvolnil cestu |

---

##  Postavy (NPC)

| Postava | Lokace | Role |
|---|---|---|
| **Veverka Čiperka** | Doubravka | Vymění mech za oříšek |
| **Včelí roj** | Včelí louka | Hlídá med – přibližuj se opatrně |
| **Jezevec Mrzout** | Opuštěný srub | Blokuje přístup k dece; pomoz mu s bolavým zubem, abys prošel |

---

##  Příkazy

Všechny příkazy jsou v **češtině**. Napiš příkaz a stiskni **Enter**.

| Příkaz | Použití | Popis |
|---|---|---|
| `jdi` | `jdi [lokace]` | Přesun do sousední lokace (např. `jdi rozcesti`) |
| `vezmi` | `vezmi [předmět]` | Sebere předmět a vloží ho do batohu |
| `poloz` | `poloz [předmět]` | Položí předmět z batohu do aktuální lokace |
| `snez` | `snez [předmět]` | Sní jídlo z batohu pro zvýšení nasycení |
| `pouzij` | `pouzij [předmět]` | Použije předmět z batohu (závisí na kontextu) |
| `mluv` | `mluv [postava]` | Promluví s postavou v aktuální lokaci |
| `prozkoumej` | `prozkoumej [věc]` | Prozkoumá předmět nebo postavu pro detailní popis |
| `spi` | `spi` | Pokus o ulehnutí k zimnímu spánku (funguje pouze v jeskyni, pokud jsou splněny všechny podmínky) |
| `pomoc` | `pomoc` | Zobrazí seznam všech dostupných příkazů |
| `konec` | `konec` | Ukončí hru |

### Příklad

jdi rozcesti  
vezmi orisek  
mluv veverka  
pouzij orisek  
vezmi mech 

---

## 🏆 Podmínky vítězství

Hru vyhraješ, když jsou splněny **všechny tři podmínky** a použiješ příkaz `spi` uvnitř lokace **Jeskyně**:

1.  **Nasycení ≥ 100** — sněz dostatek jídla (med, losos)
2.  **Postel je hotová** — použij v jeskyni deku (`deka`) i mech (`mech`)
3.  **Vchod je zablokován** — použij v jeskyni velký kámen (`kamen`)

---

##  Jak spustit

### Požadavky
- Java **JDK 21** nebo novější


### Spuštění z příkazové řádky
```bash
# Spuštění jar souboru
java -jar sigma_hra.jar
```
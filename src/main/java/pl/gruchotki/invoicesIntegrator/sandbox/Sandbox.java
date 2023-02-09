package pl.gruchotki.invoicesIntegrator.sandbox;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import pl.invoicesIntegrator.ObjectFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

class Sandbox {

    public static class Faktury {

        public Faktura faktura;

    }


    public static class Faktura {

        public VAT VAT;

    }

    public static class Stawka {

        public int Rodzaj;
        public double Wartosc;
        public String SumaNetto;

        public Stawka() {
        }

    }

    public static class VAT {

        public Stawka Stawka;

        public VAT() {
        }
    }

    public static void main(String[] args) throws IOException {
        Faktury faktury = new ObjectFactory().createFaktury();
//        System.out.println(faktury.toString());
//        Faktury faktury = new Faktury();
//        List<Faktura> faktura = faktury.getFaktura();
//        faktura.add(new Faktura());

        XmlMapper xmlMapper = new XmlMapper();

//        xmlMapper.writeValue(new File("simple_bean.xml"), faktury);
//        File file = new File("simple_bean.xml");


        Faktury value = xmlMapper.readValue(getShortXml(), Faktury.class);

        System.out.println("Hello Sandbox");

    }

    static String getXml() {
        return """
                <?xml version="1.0"?>
                <Faktury>
                    <faktura>
                        <NumerDokumentu>FV/GR/1/2022</NumerDokumentu>
                        <Nazwa>Justyna Wawro</Nazwa>
                        <Miasto>Krak&#xF3;w</Miasto>
                        <KodPocztowy>31-216</KodPocztowy>
                        <Adres>Solskiego 11 12</Adres>
                        <NIP/>
                        <MetodaPlatnosci>Przelew tradycyjny</MetodaPlatnosci>
                        <DataWystawienia>2022-11-15</DataWystawienia>
                        <DataSprzedazy>2022-11-15</DataSprzedazy>
                        <TerminPlatnosci>2022-11-15</TerminPlatnosci>
                        <Zaplacono>207.90</Zaplacono>
                        <Wartosc>207.90</Wartosc>
                        <Waluta>PLN</Waluta>
                        <Kurs/>
                        <NumerZamowienia>1</NumerZamowienia>
                        <DodatkoweInformacje/>
                        <ListPrzewozowy/>
                        <VAT>
                            <Stawka>
                                <Rodzaj>23</Rodzaj>
                                <Wartosc>38.88</Wartosc>
                                <SumaNetto>169.03</SumaNetto>
                            </Stawka>
                        </VAT>
                        <Produkty>
                            <Produkt>
                                <Nazwa>TARNAWA W&#xF3;z stra&#x17C;acki z klock&#xF3;w ma&#x142;y - drewniany samoch&#xF3;d zabawka
                                </Nazwa>
                                <Symbol/>
                                <CenaNetto>80.49</CenaNetto>
                                <CenaBrutto>99.00</CenaBrutto>
                                <CenaZakupu>65.07</CenaZakupu>
                                <Ilosc>2.000</Ilosc>
                                <VAT>23</VAT>
                                <Rabat>0.00</Rabat>
                                <WartoscNetto>160.98</WartoscNetto>
                                <WartoscBrutto>198.00</WartoscBrutto>
                                <Symbol/>
                                <EAN/>
                            </Produkt>
                            <Produkt>
                                <Nazwa>Koszty wysy&#x142;ki: Paczkomaty InPost</Nazwa>
                                <Symbol/>
                                <CenaNetto>8.05</CenaNetto>
                                <CenaBrutto>9.90</CenaBrutto>
                                <CenaZakupu>0.00</CenaZakupu>
                                <Ilosc>1.000</Ilosc>
                                <VAT>23</VAT>
                                <Rabat>0.00</Rabat>
                                <WartoscNetto>8.05</WartoscNetto>
                                <WartoscBrutto>9.90</WartoscBrutto>
                                <Symbol/>
                                <EAN/>
                            </Produkt>
                        </Produkty>
                    </faktura>
                    <faktura>
                        <NumerDokumentu>FV/GR/2/2022</NumerDokumentu>
                        <Nazwa>Ewa Godlewska-Stalka</Nazwa>
                        <Miasto>Mys&#x142;owice</Miasto>
                        <KodPocztowy>41-412</KodPocztowy>
                        <Adres>Korfantego 9/9</Adres>
                        <NIP/>
                        <MetodaPlatnosci>Przelew tradycyjny</MetodaPlatnosci>
                        <DataWystawienia>2022-11-16</DataWystawienia>
                        <DataSprzedazy>2022-11-16</DataSprzedazy>
                        <TerminPlatnosci>2022-11-16</TerminPlatnosci>
                        <Zaplacono>48.90</Zaplacono>
                        <Wartosc>48.90</Wartosc>
                        <Waluta>PLN</Waluta>
                        <Kurs/>
                        <NumerZamowienia>5</NumerZamowienia>
                        <DodatkoweInformacje/>
                        <ListPrzewozowy/>
                        <VAT>
                            <Stawka>
                                <Rodzaj>23</Rodzaj>
                                <Wartosc>9.14</Wartosc>
                                <SumaNetto>39.76</SumaNetto>
                            </Stawka>
                        </VAT>
                        <Produkty>
                            <Produkt>
                                <Nazwa>TARNAWA Sznurowany guzik</Nazwa>
                                <Symbol/>
                                <CenaNetto>31.71</CenaNetto>
                                <CenaBrutto>39.00</CenaBrutto>
                                <CenaZakupu>14.17</CenaZakupu>
                                <Ilosc>1.000</Ilosc>
                                <VAT>23</VAT>
                                <Rabat>0.00</Rabat>
                                <WartoscNetto>31.71</WartoscNetto>
                                <WartoscBrutto>39.00</WartoscBrutto>
                                <Symbol/>
                                <EAN/>
                            </Produkt>
                            <Produkt>
                                <Nazwa>Koszty wysy&#x142;ki: Paczkomaty InPost</Nazwa>
                                <Symbol/>
                                <CenaNetto>8.05</CenaNetto>
                                <CenaBrutto>9.90</CenaBrutto>
                                <CenaZakupu>0.00</CenaZakupu>
                                <Ilosc>1.000</Ilosc>
                                <VAT>23</VAT>
                                <Rabat>0.00</Rabat>
                                <WartoscNetto>8.05</WartoscNetto>
                                <WartoscBrutto>9.90</WartoscBrutto>
                                <Symbol/>
                                <EAN/>
                            </Produkt>
                        </Produkty>
                    </faktura>
                    <faktura>
                        <NumerDokumentu>FV/GR/1/2022</NumerDokumentu>
                        <Nazwa>Justyna Wawro</Nazwa>
                        <Miasto>Krak&#xF3;w</Miasto>
                        <KodPocztowy>31-216</KodPocztowy>
                        <Adres>Solskiego 11 12</Adres>
                        <NIP/>
                        <MetodaPlatnosci>Przelew tradycyjny</MetodaPlatnosci>
                        <DataWystawienia>2022-11-15</DataWystawienia>
                        <DataSprzedazy>2022-11-15</DataSprzedazy>
                        <TerminPlatnosci>2022-11-15</TerminPlatnosci>
                        <Zaplacono>207.90</Zaplacono>
                        <Wartosc>207.90</Wartosc>
                        <Waluta>PLN</Waluta>
                        <Kurs/>
                        <NumerZamowienia>1</NumerZamowienia>
                        <DodatkoweInformacje/>
                        <ListPrzewozowy/>
                        <VAT>
                            <Stawka>
                                <Rodzaj>23</Rodzaj>
                                <Wartosc>38.88</Wartosc>
                                <SumaNetto>169.03</SumaNetto>
                            </Stawka>
                        </VAT>
                        <Produkty>
                            <Produkt>
                                <Nazwa>TARNAWA W&#xF3;z stra&#x17C;acki z klock&#xF3;w ma&#x142;y - drewniany samoch&#xF3;d zabawka
                                </Nazwa>
                                <Symbol/>
                                <CenaNetto>80.49</CenaNetto>
                                <CenaBrutto>99.00</CenaBrutto>
                                <CenaZakupu>65.07</CenaZakupu>
                                <Ilosc>2.000</Ilosc>
                                <VAT>23</VAT>
                                <Rabat>0.00</Rabat>
                                <WartoscNetto>160.98</WartoscNetto>
                                <WartoscBrutto>198.00</WartoscBrutto>
                                <Symbol/>
                                <EAN/>
                            </Produkt>
                            <Produkt>
                                <Nazwa>Koszty wysy&#x142;ki: Paczkomaty InPost</Nazwa>
                                <Symbol/>
                                <CenaNetto>8.05</CenaNetto>
                                <CenaBrutto>9.90</CenaBrutto>
                                <CenaZakupu>0.00</CenaZakupu>
                                <Ilosc>1.000</Ilosc>
                                <VAT>23</VAT>
                                <Rabat>0.00</Rabat>
                                <WartoscNetto>8.05</WartoscNetto>
                                <WartoscBrutto>9.90</WartoscBrutto>
                                <Symbol/>
                                <EAN/>
                            </Produkt>
                        </Produkty>
                    </faktura>
                    <faktura>
                        <NumerDokumentu>FV/GR/2/2022</NumerDokumentu>
                        <Nazwa>Ewa Godlewska-Stalka</Nazwa>
                        <Miasto>Mys&#x142;owice</Miasto>
                        <KodPocztowy>41-412</KodPocztowy>
                        <Adres>Korfantego 9/9</Adres>
                        <NIP/>
                        <MetodaPlatnosci>Przelew tradycyjny</MetodaPlatnosci>
                        <DataWystawienia>2022-11-16</DataWystawienia>
                        <DataSprzedazy>2022-11-16</DataSprzedazy>
                        <TerminPlatnosci>2022-11-16</TerminPlatnosci>
                        <Zaplacono>48.90</Zaplacono>
                        <Wartosc>48.90</Wartosc>
                        <Waluta>PLN</Waluta>
                        <Kurs/>
                        <NumerZamowienia>5</NumerZamowienia>
                        <DodatkoweInformacje/>
                        <ListPrzewozowy/>
                        <VAT>
                            <Stawka>
                                <Rodzaj>23</Rodzaj>
                                <Wartosc>9.14</Wartosc>
                                <SumaNetto>39.76</SumaNetto>
                            </Stawka>
                        </VAT>
                        <Produkty>
                            <Produkt>
                                <Nazwa>TARNAWA Sznurowany guzik</Nazwa>
                                <Symbol/>
                                <CenaNetto>31.71</CenaNetto>
                                <CenaBrutto>39.00</CenaBrutto>
                                <CenaZakupu>14.17</CenaZakupu>
                                <Ilosc>1.000</Ilosc>
                                <VAT>23</VAT>
                                <Rabat>0.00</Rabat>
                                <WartoscNetto>31.71</WartoscNetto>
                                <WartoscBrutto>39.00</WartoscBrutto>
                                <Symbol/>
                                <EAN/>
                            </Produkt>
                            <Produkt>
                                <Nazwa>Koszty wysy&#x142;ki: Paczkomaty InPost</Nazwa>
                                <Symbol/>
                                <CenaNetto>8.05</CenaNetto>
                                <CenaBrutto>9.90</CenaBrutto>
                                <CenaZakupu>0.00</CenaZakupu>
                                <Ilosc>1.000</Ilosc>
                                <VAT>23</VAT>
                                <Rabat>0.00</Rabat>
                                <WartoscNetto>8.05</WartoscNetto>
                                <WartoscBrutto>9.90</WartoscBrutto>
                                <Symbol/>
                                <EAN/>
                            </Produkt>
                        </Produkty>
                    </faktura>
                </Faktury>
                """;
    }

    static String getShortXml() {
        return """
                <?xml version="1.0"?>
                <faktury>
                    <faktura>
                        <VAT>
                        <Stawka>
                            <Rodzaj>23</Rodzaj>
                            <Wartosc>38.88</Wartosc>
                            <SumaNetto>169.03</SumaNetto>
                        </Stawka>
                        </VAT>
                    </faktura>
                    <faktura>
                        <VAT>
                        <Stawka>
                            <Rodzaj>23</Rodzaj>
                            <Wartosc>38.88</Wartosc>
                            <SumaNetto>169.03</SumaNetto>
                        </Stawka>
                        </VAT>
                    </faktura>
                </faktury>
                """;
    }

}
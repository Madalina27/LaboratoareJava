package com.example.Laboratorul9.jdbc;

public class Masina {
    private String nr_inmatriculare;
    private String marca;
    private int an_fabricatie;
    private String culoare;
    private int nr_kilometri;

    public Masina() {}

    public Masina(String nr_inmatriculare, String marca, int an_fabricatie, String culoare, int nr_kilometri) {
        super();
        this.nr_inmatriculare = nr_inmatriculare;
        this.marca = marca;
        this.an_fabricatie = an_fabricatie;
        this.culoare = culoare;
        this.nr_kilometri = nr_kilometri;
    }

    public String getNr_inmatriculare() {
        return nr_inmatriculare;
    }

    public void setNr_inmatriculare(String nr_inmatriculare) {
        this.nr_inmatriculare = nr_inmatriculare;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAn_fabricatie() {
        return an_fabricatie;
    }

    public void setAn_fabricatie(int an_fabricatie) {
        this.an_fabricatie = an_fabricatie;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public int getNr_kilometri() {
        return nr_kilometri;
    }

    public void setNr_kilometri(int nr_kilometri) {
        this.nr_kilometri = nr_kilometri;
    }

    @Override
    public String toString() {
        return "Masina{" +
                "nr_inmatriculare='" + nr_inmatriculare + '\'' +
                ", marca='" + marca + '\'' +
                ", an_fabricatie=" + an_fabricatie +
                ", culoare='" + culoare + '\'' +
                ", nr_kilometri=" + nr_kilometri +
                '}';
    }
}

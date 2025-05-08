package br.edu.ifsp.testing.class07;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RemoveLinkedListTest {

    private LinkedList<String> list;

    @BeforeEach
    void setup() {
        list = new LinkedList<>();

    }

    @Test
    @DisplayName("Remove um valor nulo")
    public void removeUmValorNulo() {

        list.add(null);
        list.add("ana");
        list.add("candidor");

        assertThat(list.remove(null)).isEqualTo(true);
        assertThat(list.toString()).isEqualTo("[ana, candidor]");
    }

    @Test
    @DisplayName("Remove um valor nulo que não esta na primeira posicao")
    public void removeUmValorNuloQueNaoEstaNaPrimeiraPosicao() {

        list.add("ana");
        list.add("candidor");
        list.add(null);

        assertThat(list.remove(null)).isEqualTo(true);
        assertThat(list.toString()).isEqualTo("[ana, candidor]");
    }

    @Test
    @DisplayName("Remove um valor que nao contem na lista")
    public void removeUmValorQueNaoContemNaLista() {

        list.add("ana");
        list.add("candidor");

        assertThat(list.remove(null)).isEqualTo(false);
        assertThat(list.toString()).isEqualTo("[ana, candidor]");
    }

    @Test
    @DisplayName("Remove um valor nao nulo na primeira posicao")
    public void removeUmValorNaoNuloNaPrimeiraPosicao() {

        list.add("ana");
        list.add("candidor");

        assertThat(list.remove("ana")).isEqualTo(true);
        assertThat(list.toString()).isEqualTo("[candidor]");
    }

    @Test
    @DisplayName("Remove um valor nao nulo na ultima posicao")
    public void removeUmValorNaoNuloNaUltimaPosicao() {

        list.add("ana");
        list.add("candidor");

        assertThat(list.remove("candidor")).isEqualTo(true);
        assertThat(list.toString()).isEqualTo("[ana]");
    }

    @Test
    @DisplayName("Remove um valor nao nulo nao contido na lista")
    public void removeUmValorNaoNuloNaoContidoNaLista() {

        list.add("ana");
        list.add("candidor");

        assertThat(list.remove("fefeu")).isEqualTo(false);
        assertThat(list.toString()).isEqualTo("[ana, candidor]");
    }

}

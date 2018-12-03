package com.github.pauloj2000.mf2018.lonic.bancoDeDados;

import com.github.pauloj2000.mf2018.lonic.negocio.Loinc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Paulo Sales on 25/11/18.
 */
public class RepositorioLoinc {

    public Loinc consultarPorLongName(String longName) {
        String sql = "SELECT * FROM loinc WHERE long_common_name = ?";
        Loinc loinc = new Loinc();
        try {
            PreparedStatement stmt = RetorneConexaoBd().prepareStatement(sql);
            stmt.setString(1, longName);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                loinc.setLoincNum(rs.getNString("loinc_num"));
                loinc.setLongName(rs.getNString("long_common_name"));
                loinc.setShortname("shortname");
                loinc.setSubmittedUnits("submitted_units");
            }
            rs.close();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }

        return loinc;
    }

    private Connection RetorneConexaoBd() {
        return ConexaoBd.getConexaoMySQL();
    }
}

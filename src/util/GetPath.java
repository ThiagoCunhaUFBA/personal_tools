/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author thiago
 */
public class GetPath {
    public static String main() {
        String caminho = "";
        caminho = (new File(".").getAbsolutePath().substring(0, (new File(".").getAbsolutePath()).length()-1));
                return caminho;
	}
}

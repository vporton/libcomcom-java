/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.porton.comcom;

import java.util.Map;
import org.portonvictor.errno.Errno;

/**
 *
 * @author Victor Porton
 */
public class Procedural {

    static public void init() {
        if(Bindings.CLibrary.INSTANCE.libcomcom_init() == -1)
            throw new Errno();
    }

    static public byte[] run_command(
            byte[] input,
            String file,
            String[] argv,
            Map<String,String> env,
            int timeout)
    {
    }

    static public void terminate() {
        if(Bindings.CLibrary.INSTANCE.libcomcom_terminate()== -1)
            throw new Errno();
    }

}

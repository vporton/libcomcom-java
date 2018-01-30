/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.porton.comcom;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;
import java.util.Map;
import org.portonvictor.errno.Errno;

/**
 *
 * @author Victor Porton
 */
public class Procedural {

    static {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                terminate();
            }
        });
    }

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
        PointerByReference output;
        Bindings.size_t output_len;
        /* FIXME */
        Bindings.CLibrary.INSTANCE.libcomcom_run_command(
                input,
                input.length,
                output,
                Pointer.NULL,
                input,
                argv,
                envp,
                timeout);
        if(output_len.longValue() > Integer.MAX_VALUE)
            throw new OutOfMemoryError(); // correct?
        return output.getValue().getByteArray(0, output_len.intValue());
    }

    static public void terminate() {
        if(Bindings.CLibrary.INSTANCE.libcomcom_terminate() == -1)
            throw new Errno();
    }

}

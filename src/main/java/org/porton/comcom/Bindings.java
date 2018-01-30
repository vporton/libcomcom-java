/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.porton.comcom;

import com.sun.jna.*;
import com.sun.jna.ptr.*;

/**
 *
 * @author Victor Porton
 */
class Bindings {

    static {
        System.loadLibrary("comcom"); // Load native library at runtime
    }

    public static class size_t extends IntegerType {
        private static final long serialVersionUID = 1L;

        public size_t() {
            super(Native.POINTER_SIZE);
        }
        public size_t(long value) {
            super(Native.POINTER_SIZE, value);
        }
    }

    public interface CLibrary extends Library {
        CLibrary INSTANCE = (CLibrary)
            Native.loadLibrary("comcom", CLibrary.class);

        public int libcomcom_init();

        public int libcomcom_run_command(
                byte[] input,
                size_t input_len,
                PointerByReference output,
                Pointer output_len,
                byte[] file,
                PointerByReference argv,
                PointerByReference envp,
                int timeout);

        public int libcomcom_terminate();
    }
}

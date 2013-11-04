/*
 * Copyright (c) 2013, saden
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package com.github.saden1.hk2.runlevel.kernel;

import com.github.saden1.hk2.runlevel.kernel.annot.InitRunLevel;
import com.github.saden1.hk2.runlevel.kernel.annot.PostStartupRunLevel;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import org.glassfish.hk2.runlevel.RunLevelController;
import org.jvnet.hk2.annotations.Service;

/**
 *
 * @author saden
 */
@Service
public class Kernel {

    private final RunLevelController controller;

    @Inject
    public Kernel(RunLevelController controller, KernelListener listener) {
        this.controller = controller;
    }

    @PostConstruct
    public void startup() {
        System.out.println("Kernel shutting down. Proceeding to: " + PostStartupRunLevel.VAL);
        controller.proceedTo(PostStartupRunLevel.VAL);
    }

    @PreDestroy
    public void shutdown() throws InterruptedException {
        System.out.println("Kernel shutting down. Proceeding to: " + InitRunLevel.VAL);
        controller.proceedTo(InitRunLevel.VAL);
    }

}

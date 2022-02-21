package com.vbclient;

/**
 * Created by IntelliJ IDEA.
 * User: nithyasubramanian
 * Date: Jan 22, 2009
 * Time: 10:37:43 PM
 * To change this template use File | Settings | File Templates.
 *
 */
import com.sun.xml.ws.commons.virtualbox.*;

import java.util.UUID;

public class VBCreateMachine {
          private IVirtualBox virtualBox = null;

    public VBCreateMachine() {
        this.virtualBox = VirtualBox.connect("http://wssqe26.sfbay.sun.com:18083/");
    }
    public static void main(String[] args) {
        VBCreateMachine vbclient = new VBCreateMachine();


            //Create machine
            IMachine newMachine = vbclient.virtualBox.createMachine("c:/vdi", "attachedimagemc", UUID.randomUUID());
      /*

             newMachine.setName("test");
             newMachine.setDescription("Progmatically created virtual machine");
             newMachine.setOSTypeId("ubuntu");
             newMachine.setMemoryBalloonSize(1);

            //Create hard disk and image
             IHardDisk hardDisk =  (IHardDisk)vbclient.virtualBox.openHardDisk("c:/vdi/lubuntu.vdi");
            final IVirtualDiskImage image = new IVirtualDiskImage( hardDisk._this, hardDisk.port );

        //Register the hard disk
        vbclient.virtualBox.registerHardDisk(hardDisk);

        //Register the machine
        vbclient.virtualBox.registerMachine(newMachine);           */



        //Make the  machine mutable by opening a session to it
        IMachine 
        ISession session = vbclient.virtualBox.getSessionObject();
         vbclient.virtualBox.openSession(session, newMachine.getId());
         //Attach the hard disk to it
         session.getMachine().attachHardDisk(hardDisk.getId(),StorageBus.IDE,0,0);
        IConsole console = session.getConsole();
                                     console.takeSnapshot("testu1","testubuntu1");

                                       //machine.getSnapshot(UUID.fromString("3fa6e668-b199-4501-990e-17bc741f8fb2"));
                                       console.powerUp();
        
    
    }
}



package tpDHT;

import peersim.edsim.*;
import peersim.core.*;
import peersim.config.*;

/*
  Module d'initialisation de helloWorld: 
  Fonctionnement:
    pour chaque noeud, le module fait le lien entre la couche transport et la couche applicative
    ensuite, il fait envoyer au noeud 0 un message "Hello" a tous les autres noeuds
 */
public class Initializer implements peersim.core.Control {
    
    private int noeudPid;

    public Initializer(String prefix) {
	//recuperation du pid de la couche applicative
	this.noeudPid = Configuration.getPid(prefix + ".helloWorldProtocolPid");
    }

    public boolean execute() {
	int nodeNb;
	Noeud emitter, current;
	Node dest;
	Message helloMsg;

	//recuperation de la taille du reseau
	nodeNb = Network.size();
	//creation du message
	helloMsg = new Message(Message.HELLOWORLD,"Hello!!");
	if (nodeNb < 1) {
	    System.err.println("Network size is not positive");
	    System.exit(1);
	}

	//recuperation de la couche applicative de l'emetteur (le noeud 0)
	emitter = (Noeud)Network.get(0).getProtocol(this.noeudPid);
	emitter.setTransportLayer(0);

	//pour chaque noeud, on fait le lien entre la couche applicative et la couche transport
	//puis on fait envoyer au noeud 0 un message "Hello"
	for (int i = 1; i < nodeNb; i++) {
	    dest = Network.get(i);
	    current = (Noeud)dest.getProtocol(this.noeudPid);
	    current.setTransportLayer(i);
	    emitter.send(helloMsg, dest);
	}

	System.out.println("Initialization completed");
	return false;
    }
}
package tpDHT;

import helloWorld.HWTransport;
import helloWorld.HelloWorld;
import peersim.core.Node;
import peersim.edsim.EDProtocol;

public class Noeud implements EDProtocol {

	//identifiant de la couche transport
    private int transportPid;

    //objet couche transport
    private HWTransport transport;

    //identifiant de la couche courante (la couche applicative)
    private int mypid;

    //le numero de noeud
    private int nodeId;

    //prefixe de la couche (nom de la variable de protocole du fichier de config)
    private String prefix;

	public Noeud() {
		// TODO Auto-generated constructor stub
	}

	public void setTransportLayer(int i) {
		// TODO Auto-generated method stub
		
	}

	public void send(Message helloMsg, Node dest) {
		// TODO Auto-generated method stub
		
	}
	
    //methode necessaire pour la creation du reseau (qui se fait par clonage d'un prototype)
    public Object clone() {

	HelloWorld dolly = new HelloWorld(this.prefix);

	return dolly;
    }

	@Override
	public void processEvent(Node node, int pid, Object event) {
		// TODO Auto-generated method stub
		
	}


}

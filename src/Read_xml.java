
	import javax.xml.parsers.DocumentBuilderFactory;
	import javax.xml.parsers.DocumentBuilder;
	import org.w3c.dom.Document;
	import org.w3c.dom.NodeList;
	import org.w3c.dom.Node;
	import org.w3c.dom.Element;
	import java.io.File;

	public class Read_xml {

	  public static void main(String argv[]) {
		  
	    try {

		File fXmlFile = new File("T:/m.tech/oopd/xml_read.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
				
		//optional, but recommended
		//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
		doc.getDocumentElement().normalize();

		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
				
		NodeList nList = doc.getElementsByTagName("output-point");
				
		System.out.println("----------------------------");

		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
				Element eElement = (Element) nNode;

				System.out.println(" id : " + eElement.getAttribute("id"));
				if(eElement.hasAttribute("label"))
					System.out.println("label Name : " + eElement.getAttribute("label"));
				if(eElement.hasAttribute("type"))
					System.out.println("type : " + eElement.getAttribute("type"));
				
			
			  NodeList child=nNode.getChildNodes(); 
			  for (int n = 0; n < child.getLength(); n++) 
			  {
				  
				  if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				  Node nchild=child.item(n);
				  
					
					if (nchild.getNodeType() == Node.ELEMENT_NODE) {
						System.out.println("\nCurrent Nested Element is:" + nchild.getNodeName());
						Element childElement = (Element) nchild;

						System.out.println(" id : " + childElement.getAttribute("id"));
						if(childElement.hasAttribute("label"))
							System.out.println("label Name : " + childElement.getAttribute("label"));
						if(childElement.hasAttribute("type"))
							System.out.println("type : " + childElement.getAttribute("type"));
						
					}
				  }
			  }
			}	  
		}
		NodeList mList = doc.getElementsByTagName("gate");
		
		System.out.println("----------------------------");

		for (int temp1 = 0; temp1 < mList.getLength(); temp1++) {

			Node mNode = mList.item(temp1);
			if (mNode.getNodeType() == Node.ELEMENT_NODE) {
				System.out.println("\nCurrent Element :" + mNode.getNodeName());
				Element mElement = (Element) mNode;

				System.out.println(" id : " + mElement.getAttribute("id"));
				if(mElement.hasAttribute("label"))
					System.out.println("label Name : " + mElement.getAttribute("label"));
				if(mElement.hasAttribute("type"))
					System.out.println("type : " + mElement.getAttribute("type"));
				
			
			  NodeList child=mNode.getChildNodes(); 
			  for (int n = 0; n < child.getLength(); n++) 
			  {
				  
				  if (mNode.getNodeType() == Node.ELEMENT_NODE) {
				  Node nchild=child.item(n);
				  
					
					if (nchild.getNodeType() == Node.ELEMENT_NODE) {
						System.out.println("\nCurrent Nested Element is:" + nchild.getNodeName());
						Element childElement = (Element) nchild;

						System.out.println("id : " + childElement.getAttribute("id"));
						if(childElement.hasAttribute("label"))
							System.out.println("label Name : " + childElement.getAttribute("label"));
						if(childElement.hasAttribute("type"))
							System.out.println("type : " + childElement.getAttribute("type"));
						
					}
				  }
			  }
			}	  
		}

		 Element docEl = doc.getDocumentElement();       
		    Node childNode = docEl.getFirstChild();     
		    while( childNode.getNextSibling()!=null ){          
		        childNode = childNode.getNextSibling();         
		        if (childNode.getNodeType() == Node.ELEMENT_NODE) { 
		        	 if(childNode.getNodeName().equals("input-source"))
		        	 {
		            Element childElement = (Element) childNode;             
		            System.out.println("id : " + childElement.getAttribute("id"));
					if(childElement.hasAttribute("label"))
						System.out.println("label Name : " + childElement.getAttribute("label"));
					if(childElement.hasAttribute("type"))
						System.out.println("type : " + childElement.getAttribute("type"));
					
		        	 }
		        }       
		    }
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	  }

	}
	  
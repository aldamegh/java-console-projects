// 
//Mohammed AlDamegh
//  



	public class Bank {
	
			private String names[];
			
			private double balances[];
	
			private int nClients;
	
	
	public Bank() {}
	
		public Bank(int size ) {
			nClients=0;
			
			names = new String[size];
		
			balances = new double[size];
		}
	
		public int findIndexByName(String name ) {
		
		for(int i=0 ; i<nClients; i++) {
			
			if(names[i].equalsIgnoreCase(name)) {
				
				return i;
				}
			}
			return -1;
		
		}
	
		public boolean addClient(String name , double balance) {
			
			
			if(nClients<names.length) {
			
			if(findIndexByName(name)==-1) {
			names[nClients]= name;
			balances[nClients] = balance;
			
			nClients++;
			return true;
			}
			
			}
			return false;

		}

			
		
	
		public boolean deleteClient(String name ) {
			
			for(int i=0; i<nClients;i++) {
			
			if (names[i].equalsIgnoreCase(name)) {
				names[i]= names[nClients-1];
				balances[i]= balances[nClients-1];
			nClients--;
			return true;
				}
			}
		
			return false;	
		}
	
	
		public boolean deposit(String name , double amount ) {
			
			for(int i=0; i<nClients;i++) {
			
			if (names[i].equalsIgnoreCase(name)) {
				
				double temp = balances[i];
				balances[i]+=amount;
				
				System.out.println(names[i]+" was "+temp+", now "+balances[i]);
				
			return true;
				}
		
			}
			return false;
		
		}
	
	
		public boolean withdraw(String name , double amount) {
		
			for(int i=0; i<nClients;i++) {	
			if (names[i].equalsIgnoreCase(name)) {
				
				double temp = balances[i];
				
				if (balances[i]>amount)balances[i]= balances[i]-amount;
				
				System.out.println(names[i]+" was "+temp+", now "+balances[i]);
				
				if (balances[i]>amount)return true;
				}
		
			}
		
			return false;

		}
	
	
		public boolean transfer(String fName , String tName , double amount ) {
			int Fi=-1 , Ti=-1 ,i ;
			double temp1=-1 , temp2=-1;
			for( i=0; i<nClients;i++) {	
				if (names[i].equalsIgnoreCase(fName)) {
					 Fi = i; }
					 
				else if  (names[i].equalsIgnoreCase(tName)) {
					  Ti = i;	}
			}
			if (Fi!=-1 && Ti!=-1) {
				 temp1 = balances[Fi];
				 temp2 = balances[Ti];
				if (balances[Fi]>amount) { 
					balances[Fi]= balances[Fi]-amount;
				balances[Ti]+=amount;
				
				}
				
				
				System.out.println(names[Fi]+" was "+temp1+", now "+balances[Fi]);
				
				System.out.println(names[Ti]+" was "+temp2+", now "+balances[Ti]);
				if (balances[Ti]>temp2)return true;
				}
		return false;
		}
	
	
	
		public boolean transferToBank(String fName , Bank toBank , String tName ,  double amount) {
			
			int Fi=-1 ; int Ti =-1;
			double temp1=0 , temp2=0;
			if(findIndexByName(fName)!=-1){
				 Fi = findIndexByName(fName);
				for(int i=0 ; i<toBank.names.length;i++) {
			  if (toBank.names[i].equalsIgnoreCase(tName)) {
				   Ti=i;
				  temp1=balances[Fi];
				  temp2=toBank.balances[Ti];
				  if (balances[Fi]>amount) {
					  balances[Fi]=balances[Fi]-amount;
					  toBank.balances[Ti]=toBank.balances[Ti]+amount;   
				  }
				  
					System.out.println(names[Fi]+" was "+temp1+", now "+balances[Fi]);
					
					System.out.println(toBank.names[Ti]+" was "+temp2+", now "+toBank.balances[Ti]);
					
					if (toBank.balances[Ti]>temp2)return true;
			              }
			           }
	             	}
			return false;
		}
	
	
	
		public void display(String name ) {
			
				
				if (findIndexByName(name)!=-1) {
					int i=findIndexByName(name);
					System.out.println(names[i]+" "+balances[i]+" SR");
				}	
				else System.out.println("Not found");
		}
	
	
	
		public String  findMax() {
			double	MaxBal = -1;
			int  rich=-1;
			for(int i=0; i<nClients;i++) {
				
				if(MaxBal<balances[i]) {
					MaxBal=balances[i]; 
					 rich=i;
				    }
			     }
			if (MaxBal!=-1) {
				return names[rich];
			}
				return null;	
		}

	
	
 }

	

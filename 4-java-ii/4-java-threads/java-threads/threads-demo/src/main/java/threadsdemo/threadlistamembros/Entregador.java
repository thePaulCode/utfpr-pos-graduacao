package threadsdemo.threadlistamembros;

public class Entregador implements Runnable{
   ListaMembros listaMembros = new ListaMembros();
   Thread threadName;

   public Entregador(String name, ListaMembros lista){
       threadName = new Thread(this, name);
       this.listaMembros = lista;
       threadName.start();
   }

   @Override
    public void run(){
       String nameThread = Thread.currentThread().getName();
       System.out.println(nameThread + " comecando o trabalho de entrega.");
       int qtdePendente = listaMembros.getEmailPendente();
       boolean aberta = listaMembros.isAberta();
       while (aberta || qtdePendente > 0){

           try {
               String email = listaMembros.obterEmailMembro();
               if(email != null){
                   System.out.println(nameThread + " enviando email para " + email);
                   Thread.sleep(1000);
                   System.out.println("Envio para o " + nameThread + " concluido com sucesso.");
               }

           } catch (InterruptedException ex) {
               ex.printStackTrace();
           }
           aberta = listaMembros.isAberta();
           qtdePendente = listaMembros.getEmailPendente();

       }
       System.out.println("Atividades finalizadas.");
   }
}

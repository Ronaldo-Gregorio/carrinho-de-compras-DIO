import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras{
    
    private List<Item> itemCompra;

    public CarrinhoDeCompras(){
        this.itemCompra = new ArrayList<>();
    }

    public void adionarItem(String nome, double preco, int quantidade){
        for(int item = 1; item < quantidade; item ++){
            itemCompra.add(new Item(nome, preco, quantidade));
        }
        itemCompra.add(new Item(nome, preco, quantidade));
    }

    public double calcularValorTotal(){

        double valorTotal = 0.0;

        for(Item itemValor : itemCompra){
            valorTotal += itemValor.getPreco();
        }  
        return valorTotal;
    }


    public void removerItem(String nome, int quantidade){
        List<Item> itensParaRemover = new ArrayList<>();

        for(Item i : itemCompra){
            if(i.getNome().equalsIgnoreCase(nome)){
                itensParaRemover.add(i);
            }
        }
        itemCompra.removeAll(itensParaRemover);
    }

    public int exibirQuantidade(){
        return itemCompra.size();
    }

    public void exibirItem(){
        System.out.println(itemCompra);
    }

    public static void main(String[] args) {
        
        CarrinhoDeCompras c = new CarrinhoDeCompras();
        
        System.out.println("Quantidade de produtos: " + c.exibirQuantidade());

        c.adionarItem("Arroz", 29.50, 4);
        c.adionarItem("Feijão", 12.20, 2);

        System.out.println("Quantidade de produtos: " + c.exibirQuantidade());

        c.removerItem("Arroz", 0);

        System.out.println("Quantidade de produtos: " + c.exibirQuantidade());

        c.exibirItem();

        System.out.printf("Valor total de : %.2f", c.calcularValorTotal());


    }
}
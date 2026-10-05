import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int interacoes = input.nextInt();
      for(int i = 0; i < interacoes;i++){
        int bonus = input.nextInt();

        Guerreiro nina = new Guerreiro("Nina",input.nextInt(),input.nextInt(),input.nextInt()); 
        GuerreiroMagico theo = new GuerreiroMagico("Theo",input.nextInt(),input.nextInt(),input.nextInt());  
        Batalha round = new Batalha(bonus,nina,theo);
        round.lutar();
      }
    }
}
class Guerreiro{
  private String nome;
  private int ataque;
  private int defesa;
  private int level;
  public Guerreiro(String nome, int ataque, int defesa, int level){
    this.nome = nome;
    this.ataque = ataque;
    this.defesa = defesa;
    this.level = level;  
    }
  public String getNome(){
    return nome;
  }
  public void setNome(String nome){
    if(nome != null){
        this.nome = nome;
      }
    }
  public int getAtaque(){
    return ataque;
  }
  public void setAtaque(int ataque){
    if(ataque>=0&&ataque<=100){
      this.ataque = ataque;
    }
  }
  public int getDefesa(){
    return defesa;
  }
  public void setDefesa(int defesa){
    if(defesa>=0&&defesa<=100){
      this.defesa = defesa;
    }
  }
  public int getLevel(){
    return level;
  }
  public void setLevel(int level){
    if(level>=0&&level<=100){
      this.level = level;
    }
  }
  public int calcularGolpe(int bonus){
    int golpeBase = (ataque-defesa);
    if(level%2==0){
      golpeBase += bonus;
      return golpeBase;
    }
    return golpeBase;  
  }
}
class GuerreiroMagico extends Guerreiro{
  private int ataqueMagico;
  private int mana;
  public GuerreiroMagico(String nome,int ataque,int defesa,int level){
    super(nome,ataque,defesa,level);
    this.ataqueMagico = ataqueMagico;
    this.mana = 0;
  }
  public int getAtaqueMagico(){
    return ataqueMagico;
  }
  public void setAtaqueMagico(int ataqueMagico){
    this.ataqueMagico = ataqueMagico;
  }
  public int getMana(){
    return mana;
  }
  public void setMana(int mana){
    this.mana = mana;
  }
  public int calcularGolpeMagico(int bonus){
    while(mana<getLevel()){
      mana+=1;
    }
    int golpeBase = super.calcularGolpe(bonus);
    ataqueMagico = golpeBase*mana;
    return ataqueMagico;
  }
}
class Batalha{
  private int bonus;
  private Guerreiro guerreiro1;
  private GuerreiroMagico guerreiro2;
  public Batalha(int bonus,Guerreiro guerreiro1, GuerreiroMagico guerreiro2){
    this.bonus = bonus;
    this.guerreiro1 = guerreiro1;
    this.guerreiro2 = guerreiro2;
  }
  public int getBonus(){
    return bonus;
  }
  public void setBonus(int bonus){
    if(bonus>=0){
      this.bonus = bonus;
    }
  }
  public Guerreiro getGuerreiro1(){
    return guerreiro1;
  }
  public void setGuerreiro1(Guerreiro guerreiro1){
    this.guerreiro1 = guerreiro1;
  }
  public Guerreiro getGuerreiro2(){
    return guerreiro2;
  }
  public void setGuerreiro2(GuerreiroMagico guerreiro2){
    this.guerreiro2 = guerreiro2;
  }
  public void lutar(){
    int valorGolpe =  guerreiro1.calcularGolpe(getBonus());
    int valorGolpe2 = guerreiro2.calcularGolpeMagico(getBonus());
    if(valorGolpe > valorGolpe2){

      System.out.println(guerreiro1.getNome());

    }else if(valorGolpe2 > valorGolpe){
      System.out.println(guerreiro2.getNome());
    }else{
      System.out.println("EMPATE");
    }
  }
}

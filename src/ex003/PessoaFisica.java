package ex003;

public class PessoaFisica extends Contribuinte {

    private Double gastoSaude;

    public PessoaFisica(){
    }

    public PessoaFisica(String name, Double rendaAnual, Double gastoSaude) {
        super(name, rendaAnual);
        this.gastoSaude = gastoSaude;
    }

    public Double getGastoSaude() {
        return gastoSaude;
    }

    public void setGastoSaude(Double gastoSaude) {
        this.gastoSaude = gastoSaude;
    }

    @Override
    public double impostoDevido() {
        double impostoDevido = 0;
        if (super.getRendaAnual() <= 20000) {
            impostoDevido = super.getRendaAnual() * 0.15 - (0.5 * gastoSaude);
        } else if (super.getRendaAnual() > 20000) {
            impostoDevido = super.getRendaAnual() * 0.25 - (0.5 * gastoSaude);
        }
        return impostoDevido;
    }
}

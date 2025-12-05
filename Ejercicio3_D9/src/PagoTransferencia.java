public class PagoTransferencia implements MetodoPago, Verificable {
    private String numeroCuenta;
    private String banco;
    private String titular;

    public PagoTransferencia(String numeroCuenta, String banco, String titular) {
        this.numeroCuenta = numeroCuenta;
        this.banco = banco;
        this.titular = titular;
    }

    @Override
    public boolean validar() {
        return numeroCuenta.matches("\\d{10}");
    }

    @Override
    public boolean procesarPago(double monto, String referencia) {
        return true;
    }

    @Override
    public String generarComprobante() {
        return "TRANSFER-" + numeroCuenta + "-TXN";
    }

    @Override
    public boolean verificarIdentidad(String documento) {
        return documento.length() == 10;
    }

    @Override
    public boolean esSeguro() {
        return true;
    }
}

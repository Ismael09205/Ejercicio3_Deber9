public class PayPal implements MetodoPago, Reembolsable {
    private String email;
    private String token;

    public PayPal(String email, String token) {
        this.email = email;
        this.token = token;
    }

    @Override
    public boolean validar() {
        return email.contains("@");
    }

    @Override
    public boolean procesarPago(double monto, String referencia) {
        return true;
    }

    @Override
    public String generarComprobante() {
        return "PAYPAL-" + email + "-TXN";
    }

    @Override
    public boolean procesarDevolucion(double monto, String motivo) {
        return true;
    }

    @Override
    public int diasParaDevolucion() {
        return 180;
    }
}

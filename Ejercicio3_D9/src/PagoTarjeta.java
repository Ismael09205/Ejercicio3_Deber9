public class PagoTarjeta implements MetodoPago, Reembolsable, Verificable {
    private String numeroTarjeta;
    private String cvv;
    private String fechaExpiracion;
    private String titular;

    public PagoTarjeta(String numeroTarjeta, String cvv, String fechaExpiracion, String titular) {
        this.numeroTarjeta = numeroTarjeta;
        this.cvv = cvv;
        this.fechaExpiracion = fechaExpiracion;
        this.titular = titular;
    }

    @Override
    public boolean validar() {
        // valida CVV y fecha solo como ejemplo
        return cvv.matches("\\d{3}") && !fechaExpiracion.equals("2020");
    }

    @Override
    public boolean procesarPago(double monto, String referencia) {
        return true; // simulacion del pago
    }

    @Override
    public String generarComprobante() {
        String ultimos = numeroTarjeta.substring(numeroTarjeta.length() - 4);
        return "TARJETA-xxxx-" + ultimos + "-" + "TXN";
    }

    @Override
    public boolean procesarDevolucion(double monto, String motivo) {
        return true; // simulacion
    }

    @Override
    public int diasParaDevolucion() {
        return 30;
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
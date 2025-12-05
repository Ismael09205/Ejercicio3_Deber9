public class Main {
    public static void main(String[] args) {

        double totalProcesado = 0;
        double totalDevuelto = 0;

        System.out.println("=== PROCESAMIENTO DE PAGOS ===\n");

        // Pago con tarjeta
        PagoTarjeta tarjeta = new PagoTarjeta("1234567812345678", "123", "2026", "Ismael");
        System.out.println("--- Pago con Tarjeta de Credito ---");
        if (tarjeta.validar()) {
            System.out.println("Validacion exitosa");
            if (tarjeta.verificarIdentidad("1234567890")) {
                System.out.println("Identidad verificada");
                System.out.println("Metodo seguro: " + tarjeta.esSeguro());
            }
            tarjeta.procesarPago(250, "TXN-001");
            totalProcesado += 250;
            System.out.println("Pago procesado: $250.0 - Ref: TXN-001");
            System.out.println("Comprobante: " + tarjeta.generarComprobante() + "-001\n");
        }

        // Pago con PayPal
        PayPal paypal = new PayPal("usuario@email.com", "token123");
        System.out.println("--- Pago con PayPal ---");
        if (paypal.validar()) {
            System.out.println("Validacion exitosa");
            paypal.procesarPago(180, "TXN-002");
            totalProcesado += 180;
            System.out.println("Pago procesado: $180.0 - Ref: TXN-002");
            System.out.println("Comprobante: " + paypal.generarComprobante() + "-002\n");
        }

        // Pago con transferencia
        PagoTransferencia transferencia = new PagoTransferencia("1234567890", "BancoX", "Luis");
        System.out.println("--- Pago con Transferencia ---");
        if (transferencia.validar()) {
            System.out.println("Validacion exitosa");
            if (transferencia.verificarIdentidad("0987654321")) {
                System.out.println("Identidad verificada");
                System.out.println("Metodo seguro: " + transferencia.esSeguro());
            }
            transferencia.procesarPago(500, "TXN-003");
            totalProcesado += 500;
            System.out.println("Pago procesado: $500.0 - Ref: TXN-003");
            System.out.println("Comprobante: " + transferencia.generarComprobante() + "-003\n");
        }

        System.out.println("=== PROCESAMIENTO DE DEVOLUCIONES ===\n");

        // Devolucion tarjeta
        System.out.println("--- Devolucion Tarjeta ---");
        if (tarjeta.procesarDevolucion(50, "Producto defectuoso")) {
            totalDevuelto += 50;
            System.out.println("Devolucion procesada: $50.0");
            System.out.println("Motivo: Producto defectuoso");
            System.out.println("Dias permitidos: " + tarjeta.diasParaDevolucion() + " dias\n");
        }

        // Devolucion transferencia
        System.out.println("--- Devolucion Transferencia ---");
        System.out.println("Este metodo no permite devoluciones\n");

        System.out.println("TOTAL PROCESADO: $" + totalProcesado);
        System.out.println("TOTAL DEVUELTO: $" + totalDevuelto);
        System.out.println("NETO: $" + (totalProcesado - totalDevuelto));
    }
}
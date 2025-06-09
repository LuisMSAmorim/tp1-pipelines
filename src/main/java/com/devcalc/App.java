package com.devcalc;

import io.javalin.Javalin;
import io.javalin.http.BadRequestResponse;

/**
 * Classe principal da aplicação que configura e inicia o servidor web.
 */
public final class App {

    /** Porta padrão do servidor. */
    private static final int SERVER_PORT = 7070;

    /** Código de status HTTP para requisição inválida. */
    private static final int BAD_REQUEST = 400;

    /** Serviço de calculadora. */
    private static final CalculatorService CALCULATOR_SERVICE = new CalculatorService();

    private App() {
        // Construtor privado para evitar instanciação
    }

    /**
     * Método principal que inicia a aplicação.
     *
     * @param args
     *            argumentos da linha de comando (não utilizados)
     */
    public static void main(final String[] args) {
        Javalin app = Javalin.create().start(SERVER_PORT);

        app.get("/add", ctx -> {
            try {
                double a = ctx.queryParamAsClass("a", Double.class)
                        .getOrThrow(e -> new BadRequestResponse("Query parameter 'a' is missing or invalid"));
                double b = ctx.queryParamAsClass("b", Double.class)
                        .getOrThrow(e -> new BadRequestResponse("Query parameter 'b' is missing or invalid"));
                ctx.json(CALCULATOR_SERVICE.add(a, b));
            } catch (BadRequestResponse e) {
                ctx.status(BAD_REQUEST).json(e.getDetails());
            }
        });

        app.get("/subtract", ctx -> {
            try {
                double a = ctx.queryParamAsClass("a", Double.class)
                        .getOrThrow(e -> new BadRequestResponse("Query parameter 'a' is missing or invalid"));
                double b = ctx.queryParamAsClass("b", Double.class)
                        .getOrThrow(e -> new BadRequestResponse("Query parameter 'b' is missing or invalid"));
                ctx.json(CALCULATOR_SERVICE.subtract(a, b));
            } catch (BadRequestResponse e) {
                ctx.status(BAD_REQUEST).json(e.getDetails());
            }
        });

        app.get("/multiply", ctx -> {
            try {
                double a = ctx.queryParamAsClass("a", Double.class)
                        .getOrThrow(e -> new BadRequestResponse("Query parameter 'a' is missing or invalid"));
                double b = ctx.queryParamAsClass("b", Double.class)
                        .getOrThrow(e -> new BadRequestResponse("Query parameter 'b' is missing or invalid"));
                ctx.json(CALCULATOR_SERVICE.multiply(a, b));
            } catch (BadRequestResponse e) {
                ctx.status(BAD_REQUEST).json(e.getDetails());
            }
        });

        app.get("/divide", ctx -> {
            try {
                double a = ctx.queryParamAsClass("a", Double.class)
                        .getOrThrow(e -> new BadRequestResponse("Query parameter 'a' is missing or invalid"));
                double b = ctx.queryParamAsClass("b", Double.class)
                        .getOrThrow(e -> new BadRequestResponse("Query parameter 'b' is missing or invalid"));
                ctx.json(CALCULATOR_SERVICE.divide(a, b));
            } catch (IllegalArgumentException e) {
                ctx.status(BAD_REQUEST).json(java.util.Collections.singletonMap("error", e.getMessage()));
            } catch (BadRequestResponse e) {
                ctx.status(BAD_REQUEST).json(e.getDetails());
            }
        });
    }
}
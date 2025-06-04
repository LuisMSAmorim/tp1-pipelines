package com.devcalc;

import io.javalin.Javalin;
import io.javalin.http.BadRequestResponse;

public class App {

    private static CalculatorService calculatorService = new CalculatorService();

    public static void main(String[] args) {
        Javalin app = Javalin.create()
            .start(7070);

        app.get("/add", ctx -> {
            try {
                double a = ctx.queryParamAsClass("a", Double.class).getOrThrow(e -> new BadRequestResponse("Query parameter 'a' is missing or invalid"));
                double b = ctx.queryParamAsClass("b", Double.class).getOrThrow(e -> new BadRequestResponse("Query parameter 'b' is missing or invalid"));
                ctx.json(calculatorService.add(a, b));
            } catch (BadRequestResponse e) {
                ctx.status(400).json(e.getDetails());
            }
        });

        app.get("/subtract", ctx -> {
            try {
                double a = ctx.queryParamAsClass("a", Double.class).getOrThrow(e -> new BadRequestResponse("Query parameter 'a' is missing or invalid"));
                double b = ctx.queryParamAsClass("b", Double.class).getOrThrow(e -> new BadRequestResponse("Query parameter 'b' is missing or invalid"));
                ctx.json(calculatorService.subtract(a, b));
            } catch (BadRequestResponse e) {
                ctx.status(400).json(e.getDetails());
            }
        });

        app.get("/multiply", ctx -> {
            try {
                double a = ctx.queryParamAsClass("a", Double.class).getOrThrow(e -> new BadRequestResponse("Query parameter 'a' is missing or invalid"));
                double b = ctx.queryParamAsClass("b", Double.class).getOrThrow(e -> new BadRequestResponse("Query parameter 'b' is missing or invalid"));
                ctx.json(calculatorService.multiply(a, b));
            } catch (BadRequestResponse e) {
                ctx.status(400).json(e.getDetails());
            }
        });

        app.get("/divide", ctx -> {
            try {
                double a = ctx.queryParamAsClass("a", Double.class).getOrThrow(e -> new BadRequestResponse("Query parameter 'a' is missing or invalid"));
                double b = ctx.queryParamAsClass("b", Double.class).getOrThrow(e -> new BadRequestResponse("Query parameter 'b' is missing or invalid"));
                ctx.json(calculatorService.divide(a, b));
            } catch (IllegalArgumentException e) {
                ctx.status(400).json(java.util.Collections.singletonMap("error", e.getMessage()));
            } catch (BadRequestResponse e) {
                ctx.status(400).json(e.getDetails());
            }
        });
    }
} 
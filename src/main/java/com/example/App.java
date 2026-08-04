package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
public class App {

    @GetMapping("/")
    public String home() {
        return """
            <!DOCTYPE html>
            <html>
            <head>
                <title>Farm Fresh - Organic Food Marketplace</title>
                <style>
                    body { font-family: Arial; background: #f0f8f0; margin: 0; padding: 20px; }
                    .header { background: #2e7d32; color: white; padding: 20px; text-align: center; }
                    .container { max-width: 1200px; margin: 20px auto; }
                    .product-grid { display: grid; grid-template-columns: repeat(auto-fit, minmax(250px, 1fr)); gap: 20px; margin-top: 20px; }
                    .product-card { background: white; border-radius: 8px; padding: 20px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); }
                    .product-card h3 { color: #2e7d32; margin-top: 0; }
                    .price { font-size: 24px; color: #1b5e20; font-weight: bold; }
                    button { background: #4caf50; color: white; border: none; padding: 10px 20px; border-radius: 4px; cursor: pointer; }
                    button:hover { background: #45a049; }
                </style>
            </head>
            <body>
                <div class="header">
                    <h1>🌾 Farm Fresh - Direct from Farmers</h1>
                    <p>Fresh, Organic, and Healthy Food</p>
                </div>
                <div class="container">
                    <h2>Featured Products</h2>
                    <div class="product-grid">
                        <div class="product-card">
                            <h3>🥕 Organic Carrots</h3>
                            <p>Fresh from local farms. Rich in vitamins and nutrients.</p>
                            <p class="price">$3.99/kg</p>
                            <button>Add to Cart</button>
                        </div>
                        <div class="product-card">
                            <h3>🍅 Tomatoes</h3>
                            <p>Vine-ripened, organic tomatoes. Perfect for salads!</p>
                            <p class="price">$4.50/kg</p>
                            <button>Add to Cart</button>
                        </div>
                        <div class="product-card">
                            <h3>🥬 Fresh Lettuce</h3>
                            <p>Crispy, green lettuce. Harvested daily.</p>
                            <p class="price">$2.99/head</p>
                            <button>Add to Cart</button>
                        </div>
                        <div class="product-card">
                            <h3>🍎 Organic Apples</h3>
                            <p>Sweet, juicy apples. No pesticides!</p>
                            <p class="price">$5.99/kg</p>
                            <button>Add to Cart</button>
                        </div>
                        <div class="product-card">
                            <h3>🥔 Potatoes</h3>
                            <p>Farm-fresh potatoes. Great for all recipes.</p>
                            <p class="price">$2.50/kg</p>
                            <button>Add to Cart</button>
                        </div>
                        <div class="product-card">
                            <h3>🌽 Sweet Corn</h3>
                            <p>Freshly picked sweet corn. Delicious and healthy!</p>
                            <p class="price">$3.50/dozen</p>
                            <button>Add to Cart</button>
                        </div>
                    </div>
                </div>
            </body>
            </html>
            """;
    }

    @GetMapping("/api/products")
    public List<Product> getProducts() {
        return Arrays.asList(
            new Product("Organic Carrots", 3.99, "kg"),
            new Product("Tomatoes", 4.50, "kg"),
            new Product("Fresh Lettuce", 2.99, "head"),
            new Product("Organic Apples", 5.99, "kg"),
            new Product("Potatoes", 2.50, "kg"),
            new Product("Sweet Corn", 3.50, "dozen")
        );
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}

class Product {
    private String name;
    private double price;
    private String unit;

    public Product(String name, double price, String unit) {
        this.name = name;
        this.price = price;
        this.unit = unit;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getUnit() { return unit; }
}

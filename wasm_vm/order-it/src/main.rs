use actix_web::{delete, get, post, put, web, App, HttpServer};
use serde::{Deserialize, Serialize};

#[derive(Serialize, Deserialize, Debug)]
struct Order {
    id: String,
    product_id: String,
}

#[post("/orders")]
async fn create_order(order: web::Json<Order>) -> actix_web::Result<web::Json<Order>> {
    println!("request: {order:?}");
    Ok(order)
}

#[get("/orders/{id}")]
async fn get_order(id: web::Path<String>) -> actix_web::Result<web::Json<Order>> {
    let customer_order = Order {
        id: String::from(""),
        product_id: String::from(""),
    };
    println!("{id:?}");
    Ok(web::Json(customer_order))
}

#[put("/orders/{id}")]
async fn update_order(id: web::Path<String>) -> actix_web::Result<web::Json<Order>> {
    let customer_order = Order {
        id: String::from(""),
        product_id: String::from(""),
    };
    println!("{id:?}");
    Ok(web::Json(customer_order))
}

#[delete("/orders/{id}")]
async fn delete_order(id: web::Path<String>) -> actix_web::Result<web::Json<Order>> {
    let customer_order = Order {
        id: String::from(""),
        product_id: String::from(""),
    };
    println!("{id:?}");
    Ok(web::Json(customer_order))
}

#[actix_web::main]
async fn main() -> std::io::Result<()> {
    HttpServer::new(|| {
        App::new()
            .service(create_order)
            .service(get_order)
            .service(update_order)
            .service(delete_order)
    })
    .bind(("127.0.0.1", 8080))?
    .run()
    .await
}

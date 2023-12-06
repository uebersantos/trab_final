## Projeto Spring Boot  
### Verificação Estática 
A verificação realizada foi a de LongVariable na classe DesktopController. 
A variável se chama updatedDesktopComputer na linha 26 e de acordo com o PMD é um nome longo.
A solução seria trocar essa variável por um nome breve, uma das formas seria utilizar abreviação para não perder o sentido da palavra.

### Testes Unitários

### Classe: DesktopTest 

### Teste: Obter Fator de Forma

-   **Descrição:** Verifica se a obtenção do fator de forma de um desktop ocorre conforme o esperado.
-   **Entrada:**


    Desktop desktop = new Desktop("12345", "Manufacturer", 999.99, 5, "ATX");

-   **Saída Esperada:**


    assertEquals("ATX", desktop.getFormFactor());


### Teste: Definir Fator de Forma

-   **Descrição:** Verifica se a definição do fator de forma de um desktop ocorre conforme o esperado.
-   **Entrada:**


    Desktop desktop = new Desktop();
    desktop.setFormFactor("MicroATX");

-   **Saída Esperada:**


    assertEquals("MicroATX", desktop.getFormFactor());


### Teste: Construtor com Fator de Forma

-   **Descrição:** Verifica se o construtor de um desktop com um fator de forma especificado ocorre conforme o esperado.
-   **Entrada:**


    Desktop desktop = new Desktop("12345", "Manufacturer", 999.99, 5, "MiniITX");

-   **Saída Esperada:**


    assertEquals("MiniITX", desktop.getFormFactor());


### Teste: Construtor Padrão

-   **Descrição:** Verifica se o construtor padrão de um desktop inicializa o fator de forma como nulo.
-   **Entrada:**


    Desktop desktop = new Desktop();

-   **Saída Esperada:**


    assertNull(desktop.getFormFactor());


### Classe: HardDiskTest

###   Teste: Obter Capacidade

-   **Descrição:** Verifica se a obtenção da capacidade de um disco rígido ocorre conforme o esperado.
-   **Entrada:**


    HardDisk hardDisk = new HardDisk("12345", "Manufacturer", 99.99, 3, 500);

-   **Saída Esperada:**


    assertEquals(500, hardDisk.getCapacity());


### Teste: Definir Capacidade

-   **Descrição:** Verifica se a definição da capacidade de um disco rígido ocorre conforme o esperado.
-   **Entrada:**


    HardDisk hardDisk = new HardDisk();
    hardDisk.setCapacity(1000);

-   **Saída Esperada:**


    assertEquals(1000, hardDisk.getCapacity());


### Teste: Construtor com Capacidade

-   **Descrição:** Verifica se o construtor de um disco rígido com uma capacidade especificada ocorre conforme o esperado.
-   **Entrada:**


    HardDisk hardDisk = new HardDisk("67890", "AnotherManufacturer", 149.99, 2, 1000);

-   **Saída Esperada:**


    assertEquals(1000, hardDisk.getCapacity());


### Teste: Construtor Padrão

-   **Descrição:** Verifica se o construtor padrão de um disco rígido inicializa a capacidade como 0.
-   **Entrada:**


    HardDisk hardDisk = new HardDisk();

-   **Saída Esperada:**


    assertEquals(0, hardDisk.getCapacity());


### Classe: LaptopTest

###  Teste: Obter Tamanho da Tela

-   **Descrição:** Verifica se a obtenção do tamanho da tela de um laptop ocorre conforme o esperado.
-   **Entrada:**


    Laptop laptop = new Laptop("12345", "Manufacturer", 999.99, 3, 15);

-   **Saída Esperada:**


    assertEquals(15, laptop.getScreenSize());


### Teste: Definir Tamanho da Tela

-   **Descrição:** Verifica se a definição do tamanho da tela de um laptop ocorre conforme o esperado.
-   **Entrada:**


    Laptop laptop = new Laptop();
    laptop.setScreenSize(13);

-   **Saída Esperada:**


    assertEquals(13, laptop.getScreenSize());


### Teste: Construtor com Tamanho da Tela

-   **Descrição:** Verifica se o construtor de um laptop com um tamanho de tela especificado ocorre conforme o esperado.
-   **Entrada:**


    Laptop laptop = new Laptop("67890", "AnotherManufacturer", 1499.99, 2, 17);

-   **Saída Esperada:**


    assertEquals(17, laptop.getScreenSize());


### Teste: Construtor Padrão

-   **Descrição:** Verifica se o construtor padrão de um laptop inicializa o tamanho da tela como 0.
-   **Entrada:**


    Laptop laptop = new Laptop();

-   **Saída Esperada:**


    assertEquals(0, laptop.getScreenSize());


### Classe: MonitorTest

### Teste: Obter Diagonal

-   **Descrição:** Verifica se a obtenção da diagonal de um monitor ocorre conforme o esperado.
-   **Entrada:**


    Monitor monitor = new Monitor("12345", "Manufacturer", 199.99, 5, 24.5);

-   **Saída Esperada:**


    assertEquals(24.5, monitor.getDiagonal(), 0.001); // Utilize delta para lidar com imprecisões de ponto flutuante


### Teste: Definir Diagonal

-   **Descrição:** Verifica se a definição da diagonal de um monitor ocorre conforme o esperado.
-   **Entrada:**


    Monitor monitor = new Monitor();
    monitor.setDiagonal(27.0);

-   **Saída Esperada:**


    assertEquals(27.0, monitor.getDiagonal(), 0.001);


### Teste: Construtor com Diagonal

-   **Descrição:** Verifica se o construtor de um monitor com uma diagonal especificada ocorre conforme o esperado.
-   **Entrada:**


    Monitor monitor = new Monitor("67890", "AnotherManufacturer", 299.99, 3, 21.5);

-   **Saída Esperada:**


    assertEquals(21.5, monitor.getDiagonal(), 0.001);


### Teste: Construtor Padrão

-   **Descrição:** Verifica se o construtor padrão de um monitor inicializa a diagonal como 0.0.
-   **Entrada:**


    Monitor monitor = new Monitor();

-   **Saída Esperada:**


    assertEquals(0.0, monitor.getDiagonal(), 0.001);


### Classe: ProductTest

### Teste: Obter ID

-   **Descrição:** Verifica se a obtenção do ID de um produto ocorre conforme o esperado.
-   **Entrada:**


    Product product = new Product();
    product.setId(1L);

-   **Saída Esperada:**


    assertEquals(1L, product.getId());


### Teste: Definir ID

-   **Descrição:** Verifica se a definição do ID de um produto ocorre conforme o esperado.
-   **Entrada:**


    Product product = new Product();
    product.setId(2L);

-   **Saída Esperada:**


    assertEquals(2L, product.getId());


### Teste: Obter Número de Série

-   **Descrição:** Verifica se a obtenção do número de série de um produto ocorre conforme o esperado.
-   **Entrada:**


    Product product = new Product("SN123", "Manufacturer", 99.99, 5);

-   **Saída Esperada:**


    assertEquals("SN123", product.getSerialNumber());


### Teste: Definir Número de Série

-   **Descrição:** Verifica se a definição do número de série de um produto ocorre conforme o esperado.
-   **Entrada:**


    Product product = new Product();
    product.setSerialNumber("SN456");

-   **Saída Esperada:**


    assertEquals("SN456", product.getSerialNumber());


### Teste: Obter Fabricante

-   **Descrição:** Verifica se a obtenção do fabricante de um produto ocorre conforme o esperado.
-   **Entrada:**


    Product product = new Product("SN789", "AnotherManufacturer", 149.99, 3);

-   **Saída Esperada:**


    assertEquals("AnotherManufacturer", product.getManufacturer());


### Teste: Definir Fabricante

-   **Descrição:** Verifica se a definição do fabricante de um produto ocorre conforme o esperado.
-   **Entrada:**


    Product product = new Product();
    product.setManufacturer("NewManufacturer");

-   **Saída Esperada:**


    assertEquals("NewManufacturer", product.getManufacturer());


### Teste: Obter Preço

-   **Descrição:** Verifica se a obtenção do preço de um produto ocorre conforme o esperado.
-   **Entrada:**


    Product product = new Product("SN101", "YetAnotherManufacturer", 199.99, 2);

-   **Saída Esperada:**


    assertEquals(199.99, product.getPrice(), 0.001); // Utilize delta para lidar com imprecisões de ponto flutuante


### Teste: Definir Preço

-   **Descrição:** Verifica se a definição do preço de um produto ocorre conforme o esperado.
-   **Entrada:**


    Product product = new Product();
    product.setPrice(299.99);

-   **Saída Esperada:**


    assertEquals(299.99, product.getPrice(), 0.001);


### Teste: Obter Quantidade

-   **Descrição:** Verifica se a obtenção da quantidade de um produto ocorre conforme o esperado.
-   **Entrada:**


    Product product = new Product("SN202", "LastManufacturer", 399.99, 1);

-   **Saída Esperada:**


    assertEquals(1, product.getQuantity());


### Teste: Definir Quantidade

-   **Descrição:** Verifica se a definição da quantidade de um produto ocorre conforme o esperado.
-   **Entrada:**


    Product product = new Product();
    product.setQuantity(3);

-   **Saída Esperada:**


    assertEquals(3, product.getQuantity());

---

## Testes Unitários (Mock)

### Teste: Adicionar Computador Desktop

-   **Descrição:** Verifica se a adição de um computador desktop ocorre conforme o esperado.
-   **Entrada:**


    {
    "serialNumber": "123456",
    "manufacturer": "Example Manufacturer",
    "price": 999.99,
    "quantity": 10,
    "formFactor": "Desktop"
    }

-   **Saída Esperada:**


    {
    "id": 1,
    "serialNumber": "123456",
    "manufacturer": "Example Manufacturer",
    "price": 999.99,
    "quantity": 10,
    "formFactor": "Desktop"
    }


### Teste: Atualizar Computador Desktop

-   **Descrição:** Verifica se a atualização de um computador desktop ocorre conforme o esperado.
-   **Entrada:**


    {
    "serialNumber": "123456",
    "manufacturer": "Example Manufacturer",
    "price": 999.99,
    "quantity": 10,
    "formFactor": "Desktop"
    }

-   **Saída Esperada:**


    {
    "id": 1,
    "serialNumber": "123456",
    "manufacturer": "Example Manufacturer",
    "price": 999.99,
    "quantity": 10,
    "formFactor": "Desktop"
    }


### Teste: Obter Todos os Computadores Desktop

-   **Descrição:** Verifica se a obtenção de todos os computadores desktop ocorre conforme o esperado.
-   **Entrada:** N/A
-   **Saída Esperada:**


    [
    {
    "id": 1,
    "serialNumber": "123456",
    "manufacturer": "Example Manufacturer",
    "price": 999.99,
    "quantity": 10,
    "formFactor": "Desktop"
    },
    {
    "id": 2,
    "serialNumber": "789012",
    "manufacturer": "Another Manufacturer",
    "price": 1299.99,
    "quantity": 5,
    "formFactor": "Monoblock"
    }
    ]


### Teste: Obter Computador Desktop por ID

-   **Descrição:** Verifica se a obtenção de um computador desktop por ID ocorre conforme o esperado.
-   **Entrada:** N/A
-   **Saída Esperada:**


    {
    "id": 1,
    "serialNumber": "123456",
    "manufacturer": "Example Manufacturer",
    "price": 999.99,
    "quantity": 10,
    "formFactor": "Desktop"
    }


### Teste: Adicionar Disco Rígido

-   **Descrição:** Verifica se a adição de um disco rígido ocorre conforme o esperado.
-   **Entrada:**


    {
    "serialNumber": "ABC123",
    "manufacturer": "Example Manufacturer",
    "price": 99.99,
    "quantity": 5,
    "capacity": 500
    }

-   **Saída Esperada:**


    {
    "serialNumber": "ABC123",
    "manufacturer": "Example Manufacturer",
    "price": 99.99,
    "quantity": 5,
    "capacity": 500
    }


### Teste: Atualizar Disco Rígido

-   **Descrição:** Verifica se a atualização de um disco rígido ocorre conforme o esperado.
-   **Entrada:**


    {
    "serialNumber": "ABC123",
    "manufacturer": "Updated Manufacturer",
    "price": 129.99,
    "quantity": 8,
    "capacity": 1000
    }

-   **Saída Esperada:**


    {
    "serialNumber": "ABC123",
    "manufacturer": "Updated Manufacturer",
    "price": 129.99,
    "quantity": 8,
    "capacity": 1000
    }


### Teste: Obter Todos os Discos Rígidos

-   **Descrição:** Verifica se a obtenção de todos os discos rígidos ocorre conforme o esperado.
-   **Entrada:** N/A
-   **Saída Esperada:**


    [
    {
    "serialNumber": "ABC123",
    "manufacturer": "Updated Manufacturer",
    "price": 129.99,
    "quantity": 8,
    "capacity": 1000
    },
    // Outros discos rígidos, se houverem
    ]


### Teste: Obter Disco Rígido por ID

-   **Descrição:** Verifica se a obtenção de um disco rígido por ID ocorre conforme o esperado.
-   **Entrada:** N/A
-   **Saída Esperada:**


    {
    "serialNumber": "ABC123",
    "manufacturer": "Updated Manufacturer",
    "price": 129.99,
    "quantity": 8,
    "capacity": 1000
    }

###   Teste: Adicionar Laptop

-   **Descrição:** Verifica se a adição de um laptop ocorre conforme o esperado.
-   **Entrada:**


    {
    "serialNumber": "ABC123",
    "manufacturer": "Dell",
    "price": 1200.0,
    "quantity": 3,
    "screenSize": 15
    }

-   **Saída Esperada:**


    {
    "serialNumber": "ABC123",
    "manufacturer": "Dell",
    "price": 1200.0,
    "quantity": 3,
    "screenSize": 15
    }


### Teste: Atualizar Laptop

-   **Descrição:** Verifica se a atualização de um laptop ocorre conforme o esperado.
-   **Entrada:**


    {
    "serialNumber": "XYZ789",
    "manufacturer": "Lenovo",
    "price": 1500.0,
    "quantity": 5,
    "screenSize": 14
    }

-   **Saída Esperada:**


    {
    "serialNumber": "XYZ789",
    "manufacturer": "Lenovo",
    "price": 1500.0,
    "quantity": 5,
    "screenSize": 14
    }


### Teste: Obter Todos os Laptops

-   **Descrição:** Verifica se a obtenção de todos os laptops ocorre conforme o esperado.
-   **Entrada:** N/A
-   **Saída Esperada:**


    [
    {
    "serialNumber": "ABC123",
    "manufacturer": "Dell",
    "price": 1200.0,
    "quantity": 3,
    "screenSize": 15
    },
    {
    "serialNumber": "XYZ789",
    "manufacturer": "Dell",
    "price": 1200.0,
    "quantity": 3,
    "screenSize": 15
    }
    ]


### Teste: Obter Laptop por ID

-   **Descrição:** Verifica se a obtenção de um laptop por ID ocorre conforme o esperado.
-   **Entrada:** N/A
-   **Saída Esperada:**


    {
    "serialNumber": "ABC123",
    "manufacturer": "Dell",
    "price": 1200.0,
    "quantity": 3,
    "screenSize": 15
    }


### Teste: Adicionar Monitor

-   **Descrição:** Verifica se a adição de um monitor ocorre conforme o esperado.
-   **Entrada:**


    {
    "serialNumber": "ABC123",
    "manufacturer": "Dell",
    "price": 500.0,
    "quantity": 3,
    "diagonal": 24.0
    }

-   **Saída Esperada:**


    {
    "serialNumber": "ABC123",
    "manufacturer": "Dell",
    "price": 500.0,
    "quantity": 3,
    "diagonal": 24.0
    }


### Teste: Atualizar Monitor

-   **Descrição:** Verifica se a atualização de um monitor ocorre conforme o esperado.
-   **Entrada:**


    {
    "serialNumber": "XYZ789",
    "manufacturer": "Lenovo",
    "price": 600.0,
    "quantity": 4,
    "diagonal": 27.0
    }

-   **Saída Esperada:**


    {
    "serialNumber": "XYZ789",
    "manufacturer": "Lenovo",
    "price": 600.0,
    "quantity": 4,
    "diagonal": 27.0
    }


### Teste: Obter Todos os Monitores

-   **Descrição:** Verifica se a obtenção de todos os monitores ocorre conforme o esperado.
-   **Entrada:** N/A
-   **Saída Esperada:**


    [
    {
    "serialNumber": "ABC123",
    "manufacturer": "Dell",
    "price": 500.0,
    "quantity": 3,
    "diagonal": 24.0
    },
    {
    "serialNumber": "XYZ789",
    "manufacturer": "Lenovo",
    "price": 600.0,
    "quantity": 4,
    "diagonal": 27.0
    }
    ]


### Teste: Obter Monitor por ID

-   **Descrição:** Verifica se a obtenção de um monitor por ID ocorre conforme o esperado.
-   **Entrada:** N/A
-   **Saída Esperada:**


    {
    "serialNumber": "ABC123",
    "manufacturer": "Dell",
    "price": 500.0,
    "quantity": 3,
    "diagonal": 24.0
    }









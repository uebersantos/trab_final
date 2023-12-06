describe('Teste automatizado com 3 cenários ', () => {
  beforeEach(() => {
    cy.visit('https://widget-be.pmweb.com.br/qa/teste/index.html')
  })

  it('Header sem produtos na sacola', () => {
      cy.get('.progress-bar-text').should('include.text', 'Faltam R$ 100 para o frete');
  })

  it('Progresso na sacola (adição/remoção de produtos)', () => {
      cy.get(':nth-child(1) > .produto_content > .botao-comprar').click();
      cy.get('.progress-bar-text').should('include.text', 'Faltam');
    })

    it('Carrinho com frete grátis (barra de progresso 100%)', () => {
      cy.get(':nth-child(1) > .produto_content > .botao-comprar').click();
      cy.get(':nth-child(1) > .produto_content > .botao-comprar').click();
      cy.get(':nth-child(1) > .produto_content > .botao-comprar').click();
      cy.get(':nth-child(1) > .produto_content > .botao-comprar').click();
      cy.get(':nth-child(1) > .produto_content > .botao-comprar').click();
      cy.get(':nth-child(1) > .produto_content > .botao-comprar').click();
      cy.get(':nth-child(1) > .produto_content > .botao-comprar').click();
      cy.get(':nth-child(1) > .produto_content > .botao-comprar').click();
      cy.get(':nth-child(1) > .produto_content > .botao-comprar').click();
      cy.get(':nth-child(1) > .produto_content > .botao-comprar').click();
      cy.get(':nth-child(1) > .produto_content > .botao-comprar').click();
      cy.get(':nth-child(1) > .produto_content > .botao-comprar').click();
      cy.get(':nth-child(1) > .produto_content > .botao-comprar').click();
      cy.get(':nth-child(1) > .produto_content > .botao-comprar').click();
      cy.get(':nth-child(1) > .produto_content > .botao-comprar').click();
      cy.get(':nth-child(1) > .produto_content > .botao-comprar').click();
      cy.get(':nth-child(1) > .produto_content > .botao-comprar').click();
      cy.get(':nth-child(1) > .produto_content > .botao-comprar').click();
      cy.get(':nth-child(1) > .produto_content > .botao-comprar').click();
      cy.get(':nth-child(1) > .produto_content > .botao-comprar').click();
      cy.get('.progress-bar-text').should('include.text', 'Parabéns');  
    })

})
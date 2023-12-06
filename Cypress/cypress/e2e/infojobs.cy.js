describe('Verificar as vagas remotas quando busca por programador java', () => {
  it('passes', () => {
    Cypress.on('uncaught:exception', (err, runnable) => {
      return false;
  });
    
    cy.visit('https://www.infojobs.com.br/')
    cy.get('#didomi-notice-agree-button > span').click();
    cy.get('input[name="keywordsCombo"]').type('programador java{enter}');
    cy.get('#facetWorkMethod > .chip').click();
    cy.get('[href="vagas-de-emprego-programador+java-trabalho-home-office.aspx"]').click();
    cy.contains('Vagas de Emprego de programador java Home office');
    

  })
})
describe("SignIn Test", () => {
  it(".get()", () => {
    cy.visit("http://localhost:3000/login");
    cy.get('input[name="username"]').type("Dobri").should("have.value", "Dobri");
    cy.get('input[name="password"]').type("123").should("have.value", "123");
    cy.get('button[name="btn"]').click();
    cy.url().should("include", "/");
  });
});

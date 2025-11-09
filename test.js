process.env.PORT = 3001;

const { Builder, By, until } = require('selenium-webdriver');
const assert = require('assert');
const server = require('./app');  // Make sure this exports your server instance

(async function example() {
  let driver = await new Builder().forBrowser('chrome').build();
  try {
    await new Promise(resolve => setTimeout(resolve, 2000));

    await driver.get('http://localhost:3001');

    const element = await driver.wait(until.elementLocated(By.tagName('h1')), 200000);
    const text = await element.getText();

    assert.strictEqual(text, 'Hello,World!');  // No space after comma to match actual

    console.log('Test passed: Page contains "Hello,World!"');
  } catch (error) {
    console.error('Test failed:', error);
  } finally {
    await driver.quit();

    if (server && typeof server.close === 'function') {
      await new Promise(resolve => server.close(resolve));
    }

    process.exit();
  }
})();

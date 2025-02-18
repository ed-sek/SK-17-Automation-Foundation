# Home (Posts) - [Link](http://training.skillo-bg.com:4200/posts/all)

**Eduard S.**

## Description and XPath Expressions

### Navigation Bar Locators:
| **Description**                                                           | **Expression**                      | **Result**                                                                                                                                  |
|---------------------------------------------------------------------------|-------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------|
| Home icon                                                                 | `//*[@id='homeIcon']`               | `<img _ngcontent-emn-c1="" alt="homeIcon" id="homeIcon" src="../../../assets/Iskillo-logo.png" tabindex="0">`                               |
| Home button                                                               | `//*[@id="nav-link-home"]`          | `<a _ngcontent-emn-c1="" class="nav-link" id="nav-link-home" href="/posts/all">Home</a>`                                                    |
| Login button                                                              | `//*[@id="nav-link-login"]`         | `<a _ngcontent-emn-c1="" class="nav-link" id="nav-link-login" href="/users/login">Login</a>`                                                |
| Navbar toggler button (note: only visible when width of the page < 768px) | `//button[@class='navbar-toggler']` | `<button _ngcontent-jkp-c1="" class="navbar-toggler" type="button"><span _ngcontent-jkp-c1="" class="navbar-toggler-icon"></span></button>` |

### Post locators:
| **Description**     | **Expression**                                     | **Result**                                                       |
|---------------------|----------------------------------------------------|------------------------------------------------------------------|
| Post                | `//app-post-detail`                                | Selects all posts on the page (each post)                        |
| Username            | `//a[@class='post-user']`                          | Selects the usernames (authors) within each post.                |
| Profile image       | `//div[contains(@class, 'post-profile-img')]//img` | Selects the profile images in each post.                         |
| Feed image          | `//div[@class='post-feed-img']//img`               | Selects the images posted in the feed.                           |
| Like/Dislike counts | `//div[@class='d-flex']//strong`                   | Selects the like and dislike counts within the d-flex container. |
| Post date           | `//div[@class='post-date']`                        | Selects the date when each post was made.                        |

# Sign In (Login) - [Link](http://training.skillo-bg.com:4200/users/login)

**Mihail Mihaylov**

## Description and XPath Expressions

### Navigation Bar Locators:
| **Description**                                                                                             | **Expression** | **Result** |
|-------------------------------------------------------------------------------------------------------------|----------------|------------|
| Finding all clickable elements in the navigation bar with `<a>` tag                                         | `//nav//a` | `<a _ngcontent-olu-c1="" class="navbar-brand"><img _ngcontent-olu-c1="" alt="homeIcon" id="homeIcon" src="../../../assets/Iskillo-logo.png" tabindex="0"></a>`<br>`<a _ngcontent-olu-c1="" class="nav-link" id="nav-link-home" href="/posts/all">Home</a>`<br>`<a _ngcontent-olu-c1="" class="nav-link" id="nav-link-login" href="/users/login">Login</a>` |
| Finding all clickable elements in the navigation bar with `<a>` tag by descending to a specific class `nav` | `//a[contains(@class, "nav")]` | N/A |
| Finding all clickable elements in the navigation menu with `<a>` or `<button>` tags and class `nav`         | `//a[contains(@class, "nav")] \| //button[contains(@class, "nav")]` | `<a _ngcontent-olu-c1="" class="navbar-brand"><img _ngcontent-olu-c1="" alt="homeIcon" id="homeIcon" src="../../../assets/Iskillo-logo.png" tabindex="0"></a>`<br><br>`<button _ngcontent-olu-c1="" class="navbar-toggler" type="button"><span _ngcontent-olu-c1="" class="navbar-toggler-icon"></span></button>`<br><br>`<a _ngcontent-olu-c1="" class="nav-link" id="nav-link-home" href="/posts/all">Home</a>`<br>`<a _ngcontent-olu-c1="" class="nav-link" id="nav-link-login" href="/users/login">Login</a>` |
| **Alternate version of the above using Axes**                                                               | `//*[self::a or self::button][contains(@class, "nav")]` | *See above* |
| Finding all elements from `<a>` tag with `class="navbar-brand"`                                             | `//a[@class="navbar-brand"]` | `<a _ngcontent-olu-c1="" class="navbar-brand"><img _ngcontent-olu-c1="" alt="homeIcon" id="homeIcon" src="../../../assets/Iskillo-logo.png" tabindex="0"></a>` |
| Finding all elements from `<a>` tag with `class="nav-link"`                                                 | `//a[@class="nav-link"]` | `<a _ngcontent-olu-c1="" class="nav-link" id="nav-link-login" href="/users/login">Login</a>`<br>`<a _ngcontent-olu-c1="" class="nav-link" id="nav-link-home" href="/posts/all">Home</a>` |
| Finding a specific element by ID - `homeIcon`                                                               | `//*[@id="homeIcon"]` | `<img _ngcontent-olu-c1="" alt="homeIcon" id="homeIcon" src="../../../assets/Iskillo-logo.png" tabindex="0">` |
| Finding a specific element by ID - `nav-link-home`                                                          | `//*[@id="nav-link-home"]` | `<a _ngcontent-olu-c1="" class="nav-link" id="nav-link-home" href="/posts/all">Home</a>` |
| Finding a specific element by ID - `nav-link-login`                                                         | `//*[@id="nav-link-login"]` | `<a _ngcontent-olu-c1="" class="nav-link" id="nav-link-login" href="/users/login">Login</a>` |

### Form Field Locators:
| **Description** | **Expression** | **Result** |
|-----------------|----------------|------------|
| Finding all user input fields - formcontrolname attribute | `//input[@formcontrolname]` | N/A |
| Finding specific user input fields - usernameOrEmail | `//input[@formcontrolname="usernameOrEmail"]` | `<input _ngcontent-doh-c8="" class="form-control mb-4 ng-pristine ng-invalid ng-touched" formcontrolname="usernameOrEmail" id="defaultLoginFormUsername" name="usernameOrEmail" placeholder="Username or email" type="text">` |
| Finding specific user input fields - defaultLoginFormPassword | `//input[@formcontrolname="password"]` | `<input _ngcontent-doh-c8="" class="form-control mb-4 ng-untouched ng-pristine ng-invalid" formcontrolname="password" id="defaultLoginFormPassword" name="password" placeholder="Password" type="password">` |
| Finding specific user input fields - rememberMe | `//input[@formcontrolname="rememberMe"]` | `<input _ngcontent-doh-c8="" class="remember-me-button ng-untouched ng-pristine ng-valid" formcontrolname="rememberMe" type="checkbox">` |
| Finding specific element based on `<button>` tag and the containing word "Sign" | `//button[contains(text(), "Sign")]` | `<button _ngcontent-doh-c8="" block="true" class="my-4 btn btn-primary" id="sign-in-button" type="submit">Sign in</button>` |

### User Feedback Messages:
| **Description** | **Expression** | **Result** |
|-----------------|----------------|------------|
| Finding results using the role attribute | `//div[@role]` | N/A |
| Finding results using the role attribute and specific user feedback | `//div[@role="alertdialog"]` | `<div aria-live="polite" role="alertdialog" class="toast-message ng-star-inserted" aria-label="Successful login!" style=""> Successful login! </div>`<br>`<div aria-live="polite" role="alertdialog" class="toast-message ng-star-inserted" aria-label="Successful logout!" style=""> Successful logout! </div>`<br>`<div aria-live="polite" role="alertdialog" class="toast-message ng-star-inserted" aria-label="User not found" style=""> User not found </div>`<br>`<div aria-live="polite" role="alertdialog" class="toast-message ng-star-inserted" aria-label="UsernameOrEmail cannot be empty" style=""> UsernameOrEmail cannot be empty </div>`<br>`<div aria-live="polite" role="alertdialog" class="toast-message ng-star-inserted" aria-label="Password cannot be empty" style=""> Password cannot be empty </div>` |

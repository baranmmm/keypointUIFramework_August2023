package talrise.utilities;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talrise.pages.CommonPageElements;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static talrise.utilities.Driver.getDriver;


public class DynamicClick {

    private static FindBy findBy;


    public static void clickOnElement(String webElementName) {
        List<WebElement> locators = new ArrayList<>();


        try {
            List<Class<?>> classes = getClasses("talrise.pages");

            for (int i = 0; i < classes.size(); i++) {

                Field[] fields = classes.get(i).getDeclaredFields();

                for (Field field : fields) {
                    if (field.getName().equals(webElementName)) {
                        findBy = field.getAnnotation(FindBy.class);
                        locators = annotationFieldValueFinder();
                        if (locators.size() == 1) {
                            locators.get(0).click();
                            break;
                        }
                    }
                }

                if (i == classes.size() - 1 && locators.size() == 0) {
                    System.out.println("WebElement does not exist check again dynamic class ");
                    throw new NoSuchElementException();
                }

            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static List<Class<?>> getClasses(String packageName) throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        String path = packageName.replace('.', '/');
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader == null) {
            classLoader = CommonPageElements.class.getClassLoader();
        }
        URL resource = classLoader.getResource(path);
        if (resource == null) {
            throw new IllegalArgumentException("Package " + packageName + " not found");
        }
        String filePath = resource.getFile();
        File directory = new File(filePath);
        if (directory.exists()) {
            String[] files = directory.list();
            for (String fileName : files) {
                if (fileName.endsWith(".class")) {
                    String className = packageName + '.' + fileName.substring(0, fileName.length() - 6);
                    Class<?> cls = Class.forName(className);
                    classes.add(cls);
                }
            }
        }
        return classes;
    }


    public static List<WebElement> annotationFieldValueFinder() {
        String annotationValue;
        List<WebElement> webElement = new ArrayList<>();

        if (!findBy.xpath().equals("")) {
            annotationValue = findBy.xpath();
            webElement = getDriver().findElements(By.xpath(annotationValue));
        } else if (!findBy.css().equals("")) {
            annotationValue = findBy.css();
            webElement = getDriver().findElements(By.cssSelector(annotationValue));
        } else if (!findBy.id().equals("")) {
            annotationValue = findBy.id();
            webElement = getDriver().findElements(By.id(annotationValue));
        } else if (!findBy.linkText().equals("")) {
            annotationValue = findBy.linkText();
            webElement = getDriver().findElements(By.linkText(annotationValue));
        } else if (!findBy.partialLinkText().equals("")) {
            annotationValue = findBy.partialLinkText();
            webElement = getDriver().findElements(By.partialLinkText(annotationValue));
        } else if (!findBy.name().equals("")) {
            annotationValue = findBy.name();
            webElement = getDriver().findElements(By.name(annotationValue));
        } else if (!findBy.className().equals("")) {
            annotationValue = findBy.className();
            webElement = getDriver().findElements(By.className(annotationValue));
        } else if (!findBy.tagName().equals("")) {
            annotationValue = findBy.tagName();
            webElement = getDriver().findElements(By.tagName(annotationValue));
        }


        return webElement;
    }

    /**
     * Array version method.---------------------------------------------------------------
     */

    static int arraySize = 100;

    public static void clickOnElementArray(String webElementName) {
        WebElement locators[] = new WebElement[arraySize];
        try {
            Class<?> classes[] = getClassesArray("talrise.pages");
            for (int i = 0; i < classes.length; i++) {

                Field[] fields = classes[i].getDeclaredFields();

                for (Field field : fields) {
                    if (field.getName().equals(webElementName)) {
                        findBy = field.getAnnotation(FindBy.class);
                        locators = annotationFieldValueFinderArray();
                        if (locators.length == 1) {
                            locators[0].click();
                            break;
                        }
                    }
                }
                if (i == classes.length - 1 && locators.length == 0) {
                    System.out.println("WebElement does not exist check again dynamic class ");
                    throw new NoSuchElementException();
                }
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static Class<?>[] getClassesArray(String packageName) throws ClassNotFoundException {
        String path = packageName.replace('.', '/');
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader == null) {
            classLoader = CommonPageElements.class.getClassLoader();
        }
        URL resource = classLoader.getResource(path);
        if (resource == null) {
            throw new IllegalArgumentException("Package " + packageName + " not found");
        }
        String filePath = resource.getFile();
        File directory = new File(filePath);
        Class<?>[] classesArray = new Class<?>[0];
        if (directory.exists()) {
            String[] files = directory.list();
            classesArray = new Class<?>[files.length];
            int i = 0;
            for (String fileName : files) {
                if (fileName.endsWith(".class")) {
                    String className = packageName + '.' + fileName.substring(0, fileName.length() - 6);
                    Class<?> cls = Class.forName(className);
                    classesArray[i++] = cls;
                }
            }
        }
        return classesArray;
    }

    public static WebElement[] annotationFieldValueFinderArray() {
        String annotationValue;
        WebElement[] webElement = new WebElement[arraySize];
        if (!findBy.xpath().equals("")) {
            annotationValue = findBy.xpath();
            List<WebElement> elementList = getDriver().findElements(By.xpath(annotationValue));
            webElement = elementList.toArray(new WebElement[elementList.size()]);
        } else if (!findBy.css().equals("")) {
            annotationValue = findBy.css();
            List<WebElement> elementList = getDriver().findElements(By.cssSelector(annotationValue));
            webElement = elementList.toArray(new WebElement[elementList.size()]);
        } else if (!findBy.id().equals("")) {
            annotationValue = findBy.id();
            List<WebElement> elementList = getDriver().findElements(By.id(annotationValue));
            webElement = elementList.toArray(new WebElement[elementList.size()]);
        } else if (!findBy.linkText().equals("")) {
            annotationValue = findBy.linkText();
            List<WebElement> elementList = getDriver().findElements(By.linkText(annotationValue));
            webElement = elementList.toArray(new WebElement[elementList.size()]);
        } else if (!findBy.partialLinkText().equals("")) {
            annotationValue = findBy.partialLinkText();
            List<WebElement> elementList = getDriver().findElements(By.partialLinkText(annotationValue));
            webElement = elementList.toArray(new WebElement[elementList.size()]);
        } else if (!findBy.name().equals("")) {
            annotationValue = findBy.name();
            List<WebElement> elementList = getDriver().findElements(By.name(annotationValue));
            webElement = elementList.toArray(new WebElement[elementList.size()]);
        } else if (!findBy.className().equals("")) {
            annotationValue = findBy.className();
            List<WebElement> elementList = getDriver().findElements(By.className(annotationValue));
            webElement = elementList.toArray(new WebElement[elementList.size()]);
        } else if (!findBy.tagName().equals("")) {
            annotationValue = findBy.tagName();
            List<WebElement> elementList = getDriver().findElements(By.tagName(annotationValue));
            webElement = elementList.toArray(new WebElement[elementList.size()]);
        }

        webElement = removeNullOrEmptyValuesArray(webElement);
        return webElement;
    }


    public static WebElement[] removeNullOrEmptyValuesArray(WebElement[] arr) {
        // Create a new array with the same type and size as the original array
        WebElement[] newArr = new WebElement[arr.length];
        int index = 0;
        // Loop through the original array and check each element for null or empty values
        for (WebElement str : arr) {
            if (str != null) {
                // If the element is not null or empty, add it to the new array
                newArr[index] = str;
                index++;
            }
        }
        // Return the new array
        return Arrays.copyOf(newArr, index);
    }
    /**
     * Array version method.---------------------------------------------------------------
     */
}

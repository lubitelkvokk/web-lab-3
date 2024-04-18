package weblab3.beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import weblab3.dao.HitDao;
import weblab3.models.Hit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс, представляющий управление таблицей результатов.
 */
@Named("table")
@SessionScoped
public class TableBean implements Serializable {
    private List<Hit> tablePage;

    private List<Hit> currentResults = new ArrayList<>();
    private Integer pageNumber = 1;

    /**
     * Значение размера страницы для пагинации по умолчанию.
     */
    private Integer pageSize = 10;
    private HitDao hitDao;

    /**
     * Получение списка страниц таблицы.
     * @return Список страниц таблицы.
     */
    public List<Hit> getTablePage() {
        return tablePage;
    }

    /**
     * Установка списка страниц таблицы.
     * @param tablePage Список страниц таблицы.
     */
    public void setTablePage(List<Hit> tablePage) {
        this.tablePage = tablePage;
    }

    /**
     * Получение текущих результатов.
     * @return Текущие результаты.
     */
    public List<Hit> getCurrentResults() {
        return currentResults;
    }

    /**
     * Установка текущих результатов.
     * @param currentResults Текущие результаты.
     */
    public void setCurrentResults(List<Hit> currentResults) {
        this.currentResults = currentResults;
    }

    /**
     * Получение размера страницы.
     * @return Размер страницы.
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * Установка размера страницы.
     * @param pageSize Размер страницы.
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * Конструктор класса с внедрением зависимости HitDao.
     * @param hitDao DAO для управления попаданиями.
     */
    @Inject
    public TableBean(HitDao hitDao) {
        this.hitDao = hitDao;
        tablePage = hitDao.getPaginationHitList(10, 1);
    }

    /**
     * Пустой конструктор класса.
     */
    public TableBean() {
    }

    /**
     * Загрузка страницы таблицы.
     */
    public void loadPage() {
        tablePage = hitDao.getPaginationHitList(pageSize, pageNumber);
    }

    /**
     * Получение номера текущей страницы таблицы.
     * @return Номер текущей страницы.
     */
    public Integer getPageNumber() {
        return pageNumber;
    }

    /**
     * Установка номера текущей страницы таблицы.
     * @param pageNumber Номер текущей страницы.
     */
    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    /**
     * Добавление попадания в текущие результаты.
     * @param hit Попадание для добавления.
     */
    public void addToCurrentResults(Hit hit) {
        currentResults.add(hit);
    }
}

/*
 * This file is generated by jOOQ.
*/
package com.generator;


import com.generator.tables.Author;
import com.generator.tables.records.AuthorRecord;

import javax.annotation.Generated;

import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;


/**
 * A class modelling foreign key relationships between tables of the <code>library</code> 
 * schema
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AuthorRecord> KEY_AUTHOR_PRIMARY = UniqueKeys0.KEY_AUTHOR_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class UniqueKeys0 extends AbstractKeys {
        public static final UniqueKey<AuthorRecord> KEY_AUTHOR_PRIMARY = createUniqueKey(Author.AUTHOR, "KEY_author_PRIMARY", Author.AUTHOR.ID);
    }
}
